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
import java.time.*;
import java.util.ResourceBundle;

/**Controller class for updating an appointment.*/
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

    /**Method runs if the cancel button is pressed. Program returns to Main Screen. */
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

    /**Method runs if save button is pressed.  Text fields are parsed into variables and placed in a object to be modified DB. Program then returns to Main screen. */
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


            //Zone Id for current time zone
            ZoneId currentZoneID =ZoneId.systemDefault();

            //selected start time converted to current time zone
            ZonedDateTime currZoneTime = startTime.atZone(currentZoneID);

            //selected end time converted to current time zone
            ZonedDateTime currEndZoneTime = endTime.atZone(currentZoneID);

            //selected start time converted to eastern time zone
            ZonedDateTime eastZoneTime = currZoneTime.withZoneSameInstant(ZoneId.of("America/New_York"));

            //selected end time converted to eastern time zone
            ZonedDateTime eastEndZoneTime = currEndZoneTime.withZoneSameInstant(ZoneId.of("America/New_York"));

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");

            for (Appointments a : DBAppointments.getAllAppointments()) {




                if (a.getApptCustId() == apptCustId && a.getApptId()!= apptId) {


                    //this statement checks for outside appointments
                    if ((startTime.isBefore(a.getStartTime()) || startTime.isEqual(a.getStartTime())) && (endTime.isAfter(a.getEndTime())) || endTime.isEqual(a.getEndTime())) {


                        alert.setContentText("There is another appointment during this time");
                        alert.showAndWait();
                        return;

                    }

                    //this statement checks for the end time
                    if ((endTime.isBefore(a.getEndTime()) || endTime.isEqual(a.getEndTime())) && endTime.isAfter(a.getStartTime())) {


                        alert.setContentText("There is another appointment during this time");
                        alert.showAndWait();
                        return;
                    }

                    //this statement checks for start time
                    if ((startTime.isAfter(a.getStartTime()) || startTime.isEqual(a.getStartTime())) && startTime.isBefore(a.getEndTime())) {


                        alert.setContentText("There is another appointment during this time");
                        alert.showAndWait();
                        return;

                    }
                }
            }

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

            if(eastZoneTime.isBefore(ZonedDateTime.parse(updateApptScreenDatePicker.getValue() + "T08:00:00.-05:00[America/New_York]")) || eastEndZoneTime.isAfter(ZonedDateTime.parse(updateApptScreenDatePicker.getValue() + "T22:00:00.-05:00[America/New_York]"))){



                alert.setContentText("Appointment time needs to be between normal business hours (8am -10pm EST)");
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

    /**Method takes in selected appointment from Main Screen and autopopulates fields. @param appointments */
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

