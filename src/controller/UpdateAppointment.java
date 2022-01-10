package controller;

import DBAccess.DBAppointments;
import DBAccess.DBContacts;
import DBAccess.DBCustomers;
import DBAccess.DBUsers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;
import model.Contacts;
import model.Customers;
import model.Users;
import controller.AddAppointment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class UpdateAppointment implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<AddAppointment.apptTypes> typeList = FXCollections.observableArrayList();
        for(AddAppointment.apptTypes p : AddAppointment.apptTypes.values()){
            typeList.add(p);
        }

        System.out.println("Made it to the Update Appointment Screen");
        //Will need to populate all of the combo boxes upon startup OR once the combo box is clicked like I did in First Level Divisions on modify customer
        updateApptScreenEndTimeCombo.setItems(Appointments.getTimes());
        updateApptScreenCustIDCombo.setItems(DBCustomers.getAllCustomers());
        updateApptScreenUsrIDCombo.setItems(DBUsers.getAllUsers());
        updateApptScreenStartTimeCombo.setItems(Appointments.getTimes());
        updateApptScreenConCombo.setItems(DBContacts.getAllContacts());
        updateApptScreenTypeCombo.setItems(typeList);
    }

    @FXML
    private TextField updateApptScreenApptIDTxtBox;

    @FXML
    private Button updateApptScreenCnclButt;

    @FXML
    private ComboBox<Contacts> updateApptScreenConCombo;

    @FXML
    private ComboBox<Customers> updateApptScreenCustIDCombo;

    @FXML
    private DatePicker updateApptScreenDatePicker;

    @FXML
    private TextField updateApptScreenDescTxtBox;

    @FXML
    private ComboBox<LocalTime> updateApptScreenEndTimeCombo;

    @FXML
    private Button updateApptScreenSaveButt;

    @FXML
    private ComboBox<LocalTime> updateApptScreenStartTimeCombo;

    @FXML
    private TextField updateApptScreenTitleTxtBox;

    @FXML
    private ComboBox<AddAppointment.apptTypes> updateApptScreenTypeCombo;

    @FXML
    private ComboBox<Users> updateApptScreenUsrIDCombo;

    @FXML
    private TextField updateApptScreenLctnTxtBox;

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

        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        try {

            int apptId = Integer.parseInt(updateApptScreenApptIDTxtBox.getText());
            String apptTitle = updateApptScreenTitleTxtBox.getText();
            String apptDscrptn = updateApptScreenDescTxtBox.getText();
            String apptLctn = updateApptScreenLctnTxtBox.getText();
            String apptType = updateApptScreenTypeCombo.getValue().toString();
            startTime = startTime.of(updateApptScreenDatePicker.getValue(),updateApptScreenStartTimeCombo.getValue());
            endTime = endTime.of(updateApptScreenDatePicker.getValue(),updateApptScreenEndTimeCombo.getValue());
            int apptCustId = updateApptScreenCustIDCombo.getValue().getCustId();
            int apptUsrId = updateApptScreenUsrIDCombo.getValue().getId();
            int apptCntctId = updateApptScreenConCombo.getValue().getContactId();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");

            if(updateApptScreenStartTimeCombo.getValue().isAfter(updateApptScreenEndTimeCombo.getValue())||updateApptScreenStartTimeCombo.getValue().equals(updateApptScreenEndTimeCombo.getValue())){

                alert.setContentText("Start time cannot be after/same as Finish time!");
                alert.showAndWait();
                return;
            }

            if(updateApptScreenDatePicker.getValue().isBefore(LocalDate.now())){

                alert.setContentText("Date cannot be scheduled before today!");
                alert.showAndWait();
                return;
            }

            else{

            DBAppointments.modifyAppointment(apptId, apptTitle, apptDscrptn, apptLctn, apptType, startTime, endTime, apptCustId, apptUsrId, apptCntctId);}


            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            //telling program where we want it to go once button is clicked
            scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            //program makes new scene
            stage.setScene(new Scene(scene));
            //new scene starts
            stage.show();
        }

        catch (NullPointerException e){

            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Fields cannot be blank");
            error.showAndWait();
        }

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

    @FXML
    void onActionUpdateApptScreenLctnTxtBox(ActionEvent event) {

    }


    public void receiveAppointment(Appointments appointments){


        updateApptScreenApptIDTxtBox.setText((String.valueOf(appointments.getApptId())));
        updateApptScreenTitleTxtBox.setText(appointments.getApptTitle());
        updateApptScreenDescTxtBox.setText(appointments.getApptDscrptn());
        updateApptScreenDatePicker.setValue(appointments.getStartTime().toLocalDate());
        updateApptScreenStartTimeCombo.setValue(appointments.getStartTime().toLocalTime());
        updateApptScreenEndTimeCombo.setValue(appointments.getEndTime().toLocalTime());

        if(appointments.getApptType().contains("General")){updateApptScreenTypeCombo.setValue(AddAppointment.apptTypes.General);}

        if(appointments.getApptType().contains("Follow")){updateApptScreenTypeCombo.setValue(AddAppointment.apptTypes.Follow_Up);}

        if(appointments.getApptType().contains("De")){updateApptScreenTypeCombo.setValue(AddAppointment.apptTypes.DeBriefing);}

        if(appointments.getApptType().contains("Planning")){updateApptScreenTypeCombo.setValue(AddAppointment.apptTypes.Planning_Session);}

        for(Users u : DBUsers.getAllUsers()){

            if(u.getId()==appointments.getApptUsrId()){

                updateApptScreenUsrIDCombo.setValue(u);

                break;
            }
        }

        for(Customers c : DBCustomers.getAllCustomers()){

            if(c.getCustId()==appointments.getApptCustId()){

                updateApptScreenCustIDCombo.setValue(c);
                break;
            }
        }

        for(Contacts c : DBContacts.getAllContacts()){

            if(c.getContactId() == appointments.getApptCntctId()){

                updateApptScreenConCombo.setValue(c);
                break;
            }
        }

    }

}

