package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import javafx.event.ActionEvent;
//import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable{

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Made it to the Main Screen");


    }

    @FXML
    private Tab AppointmentsTab;

    @FXML
    private Tab CustomersTab;

    @FXML
    private TabPane MainScreen;

    @FXML
    private Tab ReportsTab;

    @FXML
    private Button mainAddCustomerButton;

    @FXML
    private Button mainDeleteCustomerButton;

    @FXML
    private Button mainUpdateCustomerButton;

    @FXML
    private Button mainScreenAddAppointmentButton;

    @FXML
    private TableView<?> mainScreenAppointmentTableview;

    @FXML
    private Button mainScreenDeleteAppointmentButton;

    @FXML
    private Button mainScreenUpdateAppointmentButton;


    @FXML
    void onActionMainAddCustomerButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/AddCustomer.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionMainDeleteCustomerButton(ActionEvent event) {

    }

    @FXML
    void onActionMainUpdateCustomerButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/UpdateCustomer.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionMainScreenAddAppointmentButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/AddAppointment.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionMainScreenDeleteAppointmentButton(ActionEvent event) {

    }

    @FXML
    void onActionMainScreenUpdateAppointmentButton(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/UpdateAppointment.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }



}
