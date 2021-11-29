package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Made it to the Add Appointment Screen");

    }

    @FXML
    private TextField addApptScreenApptIDTxtBox;

    @FXML
    private Button addApptScreenCnclButt;

    @FXML
    private ComboBox<?> addApptScreenConCombo;

    @FXML
    private ComboBox<?> addApptScreenCustIDCombo;

    @FXML
    private DatePicker addApptScreenDatePicker;

    @FXML
    private TextField addApptScreenDescTxtBox;

    @FXML
    private ComboBox<?> addApptScreenEndTimeCombo;

    @FXML
    private Button addApptScreenSaveButt;

    @FXML
    private ComboBox<?> addApptScreenStartTimeCombo;

    @FXML
    private TextField addApptScreenTitleTxtBox;

    @FXML
    private ComboBox<?> addApptScreenTypeCombo;

    @FXML
    private ComboBox<?> addApptScreenUsrIDCombo;

    @FXML
    void onActionAddApptScreenApptIDTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenCnclButt(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionAddApptScreenConCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenCustIDCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenDatePicker(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenDescTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenEndTimeCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenSaveButt(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionAddApptScreenStartTimeCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenTitleTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenTypeCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenUsrIDCombo(ActionEvent event) {

    }


}

