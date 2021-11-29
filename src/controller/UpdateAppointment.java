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

public class UpdateAppointment implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Made it to the Update Appointment Screen");

    }

    @FXML
    private TextField updateApptScreenApptIDTxtBox;

    @FXML
    private Button updateApptScreenCnclButt;

    @FXML
    private ComboBox<?> updateApptScreenConCombo;

    @FXML
    private ComboBox<?> updateApptScreenCustIDCombo;

    @FXML
    private DatePicker updateApptScreenDatePicker;

    @FXML
    private TextField updateApptScreenDescTxtBox;

    @FXML
    private ComboBox<?> updateApptScreenEndTimeCombo;

    @FXML
    private Button updateApptScreenSaveButt;

    @FXML
    private ComboBox<?> updateApptScreenStartTimeCombo;

    @FXML
    private TextField updateApptScreenTitleTxtBox;

    @FXML
    private ComboBox<?> updateApptScreenTypeCombo;

    @FXML
    private ComboBox<?> updateApptScreenUsrIDCombo;

    @FXML
    void onActionUpdateApptScreenApptIDTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenCnclButt(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionUpdateApptScreenConCombo(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenCustIDCombo(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenDatePicker(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenDescTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenEndTimeCombo(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenSaveButt(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionUpdateApptScreenStartTimeCombo(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenTitleTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenTypeCombo(ActionEvent event) {

    }

    @FXML
    void onActionUpdateApptScreenUsrIDCombo(ActionEvent event) {

    }


}

