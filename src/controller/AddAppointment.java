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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

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
        LocalDate x = LocalDate.now();
        LocalTime y = LocalTime.now();
        LocalDateTime w = LocalDateTime.now();
        w = w.of(x,y);
        System.out.println(w + "this worked");*/



        //TODO this is how you would convert from localtime to localdatetime


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

    @FXML
    void onActionAddApptScreenSaveButt(javafx.event.ActionEvent actionEvent) throws IOException {

        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        try{
            int apptId = 0;
            String apptTitle = addApptScreenTitleTxtBox.getText();
            String apptDscrptn = addApptScreenDescTxtBox.getText();
            String apptLctn = addApptScreenLctnTxtBox.getText();
            String apptType = addApptScreenTypeCombo.getValue().toString();
            LocalDate apptDate = addApptScreenDatePicker.getValue();
            startTime = startTime.of(addApptScreenDatePicker.getValue(),addApptScreenStartTimeCombo.getValue());
            endTime = endTime.of(addApptScreenDatePicker.getValue(),addApptScreenStartTimeCombo.getValue());
            int apptCustId = addApptScreenCustIDCombo.getValue().getCustId();
            int apptUsrId = addApptScreenUsrIDCombo.getValue().getId();
            int apptCntctId = addApptScreenConCombo.getValue().getContactId();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");

            if(addApptScreenStartTimeCombo.getValue().isAfter(addApptScreenEndTimeCombo.getValue())||addApptScreenStartTimeCombo.getValue().equals(addApptScreenEndTimeCombo.getValue())){

                alert.setContentText("Start time cannot be after/same as Finish time!");
                alert.showAndWait();
                return;
            }

            if(addApptScreenDatePicker.getValue().isBefore(LocalDate.now())){

                alert.setContentText("Date cannot be scheduled before today!");
                alert.showAndWait();
                return;
            }

            else{


           DBAppointments.createAppointment(apptId,apptTitle,apptDscrptn,apptLctn,apptType,startTime,endTime,apptCustId,apptUsrId,apptCntctId);}


        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();}

        catch (NullPointerException e){

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

