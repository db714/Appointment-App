package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomer implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Made it to Add Customer Screen");

    }

    @FXML
    private Pane Add_Customer;

    @FXML
    private ComboBox<?> FirstLevelComboBox;

    @FXML
    private ComboBox<?> SecondLevelComboBox;

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
    private Label userIDLabel;

    @FXML
    private TextField userIDTextBox;

    @FXML
    private Button addCustomerCancelButton;

    @FXML
    private Button addCustomerSaveButton;


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

    @FXML
    void onActionAddCustomerSaveButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionAddressTextBox(ActionEvent event) {

    }

    @FXML
    void onActionFirstLevelComboBox(ActionEvent event) {

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

