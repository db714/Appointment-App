package controller;

import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import DBAccess.DBFirstLevelDivisions;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Customers;
import model.FirstLevelDivisions;

public class UpdateCustomer implements Initializable {
    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Made it to the Update Customer Screen");
       updateCustomerFirstLevelComboBox.setItems(DBCountries.getAllCountries());





    }
    @FXML
    private Pane Add_Customer;

    @FXML
    private Label addressLabel;

    @FXML
    private Label firstlevelLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label secondLevelLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private TextField updateCustomerAddressTextBox;

    @FXML
    private Button updateCustomerCancelButton;

    @FXML
    private ComboBox<String> updateCustomerFirstLevelComboBox;

    @FXML
    private TextField updateCustomerNameTextBox;

    @FXML
    private TextField updateCustomerPostalCodeTextBox;

    @FXML
    private Button updateCustomerSaveButton;

    @FXML
    private ComboBox<FirstLevelDivisions> updateCustomerSecondLevelComboBox;

    @FXML
    private TextField updateCustomerTelephoneTextBox;

    @FXML
    private TextField updateCustomerCustIDTextBox;

    @FXML
    private Label custIDLabel;

    @FXML
    void onActionUpdateCustomerAddressTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerCancelButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionUpdateCustomerFirstLevelComboBox(ActionEvent event) {

        System.out.println("this was selected on arrow click");

        //This block populates the combo box with all available options of divisions
        int cID;

        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 0){
            cID = 1;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("State");});
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 1){
            cID = 2;
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 2){
            cID = 3;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("Province");});
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }



    }

    @FXML
    void onActionUpdateCustomerNameTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerPostalCodeTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerSaveButton(javafx.event.ActionEvent actionEvent) throws IOException {

        try{

            //TODO come back to do data validation if statements

            int custId = Integer.parseInt(updateCustomerCustIDTextBox.getText());
            String custName = updateCustomerNameTextBox.getText();
            String custAddress = updateCustomerAddressTextBox.getText();
            String postCode = updateCustomerPostalCodeTextBox.getText();
            String phoneNum = updateCustomerTelephoneTextBox.getText();
            int custDiv = updateCustomerSecondLevelComboBox.getValue().getDivisionId();
            String custCntry = updateCustomerFirstLevelComboBox.getValue();

            DBCustomers.modifyCustomer(custId,custName,custAddress,postCode,phoneNum,custDiv);


        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();}



        catch (NullPointerException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Fields cannot be blank");
            error.showAndWait();
        }

    }

    @FXML
    void onActionUpdateCustomerSecondLevelComboBox(ActionEvent event) {


    }

    @FXML
    void onActionUpdateCustomerTelephoneTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerUserIDTextBox(ActionEvent event) {

    }

    public void receiveCustomer(Customers customers){

        updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(customers.getCustId()));

        updateCustomerCustIDTextBox.setText((String.valueOf(customers.getCustId())));
        updateCustomerNameTextBox.setText(customers.getCustName());
        updateCustomerAddressTextBox.setText(customers.getCustAddress());
        updateCustomerPostalCodeTextBox.setText(customers.getPostCode());
        updateCustomerTelephoneTextBox.setText(customers.getPhoneNum());
        updateCustomerFirstLevelComboBox.setValue(customers.getCustCntry());
        System.out.println(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex());

        /*int country = 0;

        if(customers.getCustCntry().equals("U.S")) {country = 1;}
        if(customers.getCustCntry().equals("UK")){ country = 2;}
        if(customers.getCustCntry().equals("Canada")){ country = 3;}*/
        int cID = 0;
        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 0){
            cID = 1;}
        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 1){
            cID = 2;}
        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 2){
            cID = 3;}

       updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));

        //This block populates the combo box with the specific division of that customer
        for(FirstLevelDivisions f : DBFirstLevelDivisions.getAllDivisions(cID)){

            if(f.getDivision().equals(customers.getCustDiv())){

                updateCustomerSecondLevelComboBox.setValue(f);
                System.out.println("It worked");

                break;

            }

        }


        //updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));



       /* //This block populates the combo box with all available options of divisions


        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 0){
            cID = 1;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("State");});
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 1){
            cID = 2;
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(updateCustomerFirstLevelComboBox.getSelectionModel().getSelectedIndex() == 2){
            cID = 3;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("Province");});
            updateCustomerSecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }
*/

    }


}
