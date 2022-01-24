package controller;

import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import DBAccess.DBFirstLevelDivisions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.FirstLevelDivisions;
import java.util.EventObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This is the controller class for adding a new customer*/
public class AddCustomer implements Initializable {

    Stage stage;
    Parent scene;
    private static int next_ID = 3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Made it to Add Customer Screen");
        FirstLevelComboBox.setItems(DBCountries.getAllCountries());

        FirstLevelComboBox.setPromptText("Please select a country");

    }

    @FXML
    private Pane Add_Customer;

    @FXML
    private ComboBox<String> FirstLevelComboBox;

    @FXML
    private ComboBox<FirstLevelDivisions> SecondLevelComboBox;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    private Label firstlevelLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextBox;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private TextField postalCodeTextBox;

    @FXML
    private Label secondLevelLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private TextField telephoneTextBox;

    @FXML
    private Label custIDLabel;

    @FXML
    private TextField custIDTextBox;

    @FXML
    private Button addCustomerCancelButton;

    @FXML
    private Button addCustomerSaveButton;

/**Method runs if the cancel button is pressed on the add customer screen. Application returns to main screen. */
    @FXML
    void onActionAddCustomerCancelButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    /**Method runs if the save button is pressed.  The textfields are parsed and put into variables that create a Customer object that is saved to DB. Program then returns to Main Screen. */
    @FXML
    void onActionAddCustomerSaveButton(javafx.event.ActionEvent actionEvent) throws IOException {

        try{

            //this is an auto incremented key that I need to grab from database
            int custId = ++next_ID;
            String custName = nameTextBox.getText();
            String custAddress = addressTextBox.getText();
            String postCode = postalCodeTextBox.getText();
            String phoneNum = telephoneTextBox.getText() ;
            int custDiv = SecondLevelComboBox.getValue().getDivisionId();
            String custCntry = FirstLevelComboBox.getValue();

            DBCustomers.createCustomer(custId, custName, custAddress,postCode,phoneNum, custDiv);





        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();
        }


        catch(NullPointerException e){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Please enter values in all text fields");
            error.showAndWait();
        }



    }

    @FXML
    void onActionAddressTextBox(ActionEvent event) {

    }

    /** Method autopopulates SecondLevel combobox if an option is selected from here. */
    @FXML
    void onActionFirstLevelComboBox(ActionEvent event) {



        int cID;

        if(FirstLevelComboBox.getSelectionModel().getSelectedIndex() == 0){
            cID = 1;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("State");});
            SecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(FirstLevelComboBox.getSelectionModel().getSelectedIndex() == 1){
            cID = 2;
            SecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }

        if(FirstLevelComboBox.getSelectionModel().getSelectedIndex() == 2){
            cID = 3;
            //secondLevelLabel.setOnAction(value-> {sourceLabel.setText("Province");});
            SecondLevelComboBox.setItems(DBFirstLevelDivisions.getAllDivisions(cID));
        }


    }

    @FXML
    void onActionNameTextBox(ActionEvent event) {

    }

    @FXML
    void onActionPostCodeTextBox(ActionEvent event) {

    }

    @FXML
    void onActionSecondLevelComboBox(ActionEvent event) {




    }

    @FXML
    void onActionTelephoneTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUserIDTextBox(ActionEvent event) {

    }


}

