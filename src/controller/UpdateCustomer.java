package controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UpdateCustomer implements Initializable {
    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Made it to the Update Customer Screen");

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
    private ComboBox<?> updateCustomerFirstLevelComboBox;

    @FXML
    private TextField updateCustomerNameTextBox;

    @FXML
    private TextField updateCustomerPostalCodeTextBox;

    @FXML
    private Button updateCustomerSaveButton;

    @FXML
    private ComboBox<?> updateCustomerSecondLevelComboBox;

    @FXML
    private TextField updateCustomerTelephoneTextBox;

    @FXML
    private TextField updateCustomerUserIDTextBox;

    @FXML
    private Label userIDLabel;

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

    }

    @FXML
    void onActionUpdateCustomerNameTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerPostalCodeTextBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomerSaveButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

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


}
