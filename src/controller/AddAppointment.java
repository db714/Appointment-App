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

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

/**Add Appointment class. Controller class that controls the adding of an appointment*/
public class AddAppointment implements Initializable {

    Stage stage;
    Parent scene;
    enum apptTypes{General,Follow_Up,DeBriefing,Planning_Session};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Made it to the Add Appointment Screen");

        ObservableList<apptTypes> typeList = FXCollections.observableArrayList();
        for(apptTypes p : apptTypes.values()){
            typeList.add(p);
        }
        addApptScreenTypeCombo.setItems(typeList);
        addApptScreenUsrIDCombo.setItems(DBUsers.getAllUsers());
        addApptScreenConCombo.setItems(DBContacts.getAllContacts());
        addApptScreenCustIDCombo.setItems(DBCustomers.getAllCustomers());

        /*String date = LocalDate.now().toString();
        String t = "T";
        String time = "09:45:00";
        LocalDateTime comb = LocalDateTime.parse(date + t + time);
        System.out.println(comb);

        w = w.of(x,y);
        System.out.println(w + "this worked");*/
        ZoneId cID = ZoneId.of("America/Chicago");
        ZoneId estID = ZoneId.of("America/New_York");
        LocalDateTime w = LocalDateTime.now();
        ZonedDateTime z = w.atZone(cID);
        ZonedDateTime zz = z.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("my time: " + z.getHour());
        System.out.println("eastern time: " + zz.getHour());






        addApptScreenStartTimeCombo.setItems(Appointments.getTimes());
        addApptScreenEndTimeCombo.setItems(Appointments.getTimes());

    }

    @FXML
    private TextField addApptScreenApptIDTxtBox;

    @FXML
    private Button addApptScreenCnclButt;

    @FXML
    private ComboBox<Contacts> addApptScreenConCombo;

    @FXML
    private ComboBox<Customers> addApptScreenCustIDCombo;

    @FXML
    private DatePicker addApptScreenDatePicker;

    @FXML
    private TextField addApptScreenDescTxtBox;

    @FXML
    private ComboBox<LocalTime> addApptScreenEndTimeCombo;

    @FXML
    private Button addApptScreenSaveButt;

    @FXML
    private ComboBox<LocalTime> addApptScreenStartTimeCombo;

    @FXML
    private TextField addApptScreenTitleTxtBox;

    @FXML
    private ComboBox<apptTypes> addApptScreenTypeCombo;

    @FXML
    private ComboBox<Users> addApptScreenUsrIDCombo;

    @FXML
    private TextField addApptScreenLctnTxtBox;

    @FXML
    void onActionAddApptScreenApptIDTxtBox(ActionEvent event) {

    }

    /** method runs if the cancel button is pressed and returns to main screen. */
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

    /**method that runs if a date is selected from the datepicker widget. */
    @FXML
    void onActionAddApptScreenDatePicker(ActionEvent event) {

        System.out.println(addApptScreenDatePicker.getValue());

        System.out.println(addApptScreenDatePicker.getValue().toString());
    }

    @FXML
    void onActionAddApptScreenDescTxtBox(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenEndTimeCombo(ActionEvent event) {

    }

    @FXML
    void onActionAddApptScreenLctnTxtBox(ActionEvent event) {

    }

    /**Method runs when the save button is pressed. All fields are saved into object and sent to DB. Program returns to Main Screen. */
    @FXML
    void onActionAddApptScreenSaveButt(javafx.event.ActionEvent actionEvent) throws IOException {

        LocalDateTime startTime = null;
        LocalDateTime endTime = null;




        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");

        try {
            int apptId = 0;
            String apptTitle = addApptScreenTitleTxtBox.getText();
            String apptDscrptn = addApptScreenDescTxtBox.getText();
            String apptLctn = addApptScreenLctnTxtBox.getText();
            String apptType = addApptScreenTypeCombo.getValue().toString();
            LocalDate apptDate = addApptScreenDatePicker.getValue();
            startTime = startTime.of(addApptScreenDatePicker.getValue(), addApptScreenStartTimeCombo.getValue());
            endTime = endTime.of(addApptScreenDatePicker.getValue(), addApptScreenEndTimeCombo.getValue());
            int apptCustId = addApptScreenCustIDCombo.getValue().getCustId();
            int apptUsrId = addApptScreenUsrIDCombo.getValue().getId();
            int apptCntctId = addApptScreenConCombo.getValue().getContactId();

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




            for (Appointments a : DBAppointments.getAllAppointments()) {




                if (a.getApptCustId() == apptCustId) {


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

            if (addApptScreenStartTimeCombo.getValue().isAfter(addApptScreenEndTimeCombo.getValue()) || addApptScreenStartTimeCombo.getValue().equals(addApptScreenEndTimeCombo.getValue())) {

                alert.setContentText("Start time cannot be after/same as Finish time!");
                alert.showAndWait();
                return;
            }

            if (addApptScreenDatePicker.getValue().isBefore(LocalDate.now())) {

                alert.setContentText("Date cannot be scheduled before today!");
                alert.showAndWait();
                return;
            }

            if(eastZoneTime.isBefore(ZonedDateTime.parse(addApptScreenDatePicker.getValue() + "T08:00:00.-05:00[America/New_York]")) || eastEndZoneTime.isAfter(ZonedDateTime.parse(addApptScreenDatePicker.getValue() + "T22:00:00.-05:00[America/New_York]"))){



                alert.setContentText("Appointment time needs to be between normal business hours (8am -10pm EST)");
                alert.showAndWait();
                return;
            }

            else {


                DBAppointments.createAppointment(apptId, apptTitle, apptDscrptn, apptLctn, apptType, startTime, endTime, apptCustId, apptUsrId, apptCntctId);
            }


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

