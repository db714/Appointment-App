package controller;

import DBAccess.DBAppointments;
import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customers;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.RadioButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;
import java.util.ResourceBundle;

import model.*;

/**Controller class for the Main Screen.*/
public class MainScreen implements Initializable{

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Made it to the Main Screen");

        customerTableview.setItems(DBCustomers.getAllCustomers());

        custIDColumn.setCellValueFactory(new PropertyValueFactory<>("custId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("custName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        divisionColumn.setCellValueFactory(new PropertyValueFactory<>("custDiv"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("custCntry"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postCode"));

        mainScreenAppointmentTableview.setItems(DBAppointments.getAllAppointments());

        apptIDCol.setCellValueFactory(new PropertyValueFactory<>("apptId"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("apptTitle"));
        apptDescCol.setCellValueFactory(new PropertyValueFactory<>("apptDscrptn"));
        apptLocCol.setCellValueFactory(new PropertyValueFactory<>("apptLctn"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptSTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        apptETimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        apptCustIDCol.setCellValueFactory(new PropertyValueFactory<>("apptCustId"));
        apptUsrIDCol.setCellValueFactory(new PropertyValueFactory<>("apptUsrId"));
        apptConIDCol.setCellValueFactory(new PropertyValueFactory<>("apptCntctId"));

        allRB.setSelected(true);

        reportsTotalCountryCombo.setItems(DBCountries.getAllCountries());

        reportsScheduleCombo.setItems(DBCustomers.getAllCustomers());

        reportsScheduleAIDCol.setCellValueFactory(new PropertyValueFactory<>("apptId"));
        reportsScheduleTitleCol.setCellValueFactory(new PropertyValueFactory<>("apptTitle"));
        reportsScheduleTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        reportsScheduleDescCol.setCellValueFactory(new PropertyValueFactory<>("apptDscrptn"));
        reportsScheduleSTCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        reportsScheduleETCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        reportsScheduleCIDCol.setCellValueFactory(new PropertyValueFactory<>("apptCustId"));

        ObservableList<Month> mList = FXCollections.observableArrayList();
        for(Month m : Month.values()){
            mList.add(m);
        }

        reportAppointmentsMonthCombo.setItems(mList);

        ObservableList<AddAppointment.apptTypes> tList = FXCollections.observableArrayList();
        for(AddAppointment.apptTypes a : AddAppointment.apptTypes.values()){
            tList.add(a);
        }

        reportsAppointmentsTypeCombo.setItems(tList);


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
    private TableView<Appointments> mainScreenAppointmentTableview;

    @FXML
    private Button mainScreenDeleteAppointmentButton;

    @FXML
    private Button mainScreenUpdateAppointmentButton;

    @FXML
    private TableView<Customers> customerTableview;

    @FXML
    private TableColumn<Customers, String> addressColumn;

    @FXML
    private TableColumn<Customers, String> countryColumn;

    @FXML
    private TableColumn<Customers, String> divisionColumn;

    @FXML
    private TableColumn<Customers, String> nameColumn;

    @FXML
    private TableColumn<Customers, String> postalCodeColumn;

    @FXML
    private TableColumn<Customers, String> telephoneColumn;

    @FXML
    private TableColumn<Customers, Integer> custIDColumn;

    @FXML
    private TableColumn<Appointments, Integer> apptConIDCol;

    @FXML
    private TableColumn<Appointments, Integer> apptCustIDCol;

    @FXML
    private TableColumn<Appointments, String> apptDescCol;

    @FXML
    private TableColumn<Appointments, LocalDateTime> apptETimeCol;

    @FXML
    private TableColumn<Appointments, Integer> apptIDCol;

    @FXML
    private TableColumn<Appointments, String> apptLocCol;

    @FXML
    private TableColumn<Appointments, LocalDateTime> apptSTimeCol;

    @FXML
    private TableColumn<Appointments, String> apptTitleCol;

    @FXML
    private TableColumn<Appointments, String> apptTypeCol;

    @FXML
    private TableColumn<Appointments, Integer> apptUsrIDCol;


    @FXML
    private RadioButton allRB;

    @FXML
    private RadioButton weekRB;

    @FXML
    private RadioButton monthRB;

    @FXML
    private ComboBox<Month> reportAppointmentsMonthCombo;

    @FXML
    private TextField reportsAppointmentsTxt;

    @FXML
    private ComboBox<AddAppointment.apptTypes> reportsAppointmentsTypeCombo;

    @FXML
    private TableColumn<?, ?> reportsScheduleAIDCol;

    @FXML
    private TableColumn<?, ?> reportsScheduleCIDCol;

    @FXML
    private ComboBox<Customers> reportsScheduleCombo;

    @FXML
    private TableColumn<?, ?> reportsScheduleDescCol;

    @FXML
    private TableColumn<?, ?> reportsScheduleETCol;

    @FXML
    private TableColumn<?, ?> reportsScheduleSTCol;

    @FXML
    private TableView<Appointments> reportsScheduleTableview;

    @FXML
    private TableColumn<?, ?> reportsScheduleTitleCol;

    @FXML
    private TableColumn<?, ?> reportsScheduleTypeCol;

    @FXML
    private ComboBox<String> reportsTotalCountryCombo;

    @FXML
    private TextField reportsTotalTxt;


    /**Method runs if Add Customer button is pressed.  Program loads add customer screen. */
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

    /**Method runs if Delete Customer button is pressed.  Once a customer is selected from the table the method will delete the customer from the program and DB. */
    @FXML
    void onActionMainDeleteCustomerButton(ActionEvent event) {

        try {
            int custId = customerTableview.getSelectionModel().getSelectedItem().getCustId();
            Customers selectedCustomer = customerTableview.getSelectionModel().getSelectedItem();
            Alert alertConf = new Alert(Alert.AlertType.CONFIRMATION);

            if (selectedCustomer != null) {
                alertConf.setTitle("Delete Customer");
                alertConf.setContentText("Are you sure you wish to delete this customer? (All appointments attached to customer will also be deleted)");
                Optional<ButtonType> result = alertConf.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {


                    for (Appointments a : DBAppointments.getAllAppointments()) {

                        if (a.getApptCustId() == custId) {
                            DBAppointments.deleteAppointment(a.getApptId());
                        }
                    }

                    DBCustomers.deleteCustomer(custId);
                    customerTableview.setItems(DBCustomers.getAllCustomers());
                    mainScreenAppointmentTableview.setItems(DBAppointments.getAllAppointments());
                }
            }
        }

        catch (NullPointerException n){
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setContentText("Customer must be selected");
            alertError.showAndWait();
        }

    }

    /**Method runs if Update Customer Button is pressed. Program loads update customer form upon customer selection. */
    @FXML
    void onActionMainUpdateCustomerButton(javafx.event.ActionEvent actionEvent) throws IOException {

        try{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/UpdateCustomer.fxml"));
            loader.load();
            UpdateCustomer updateCustomerController = loader.getController();
            Customers c = customerTableview.getSelectionModel().getSelectedItem();
            //FirstLevelDivisions f = (FirstLevelDivisions) customerTableview.getSelectionModel().getSelectedCells();
            System.out.println(c.getCustDiv());

            updateCustomerController.receiveCustomer(c);





        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        //telling program where we want it to go once button is clicked
        //scene = FXMLLoader.load(getClass().getResource("/view/UpdateCustomer.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();}


        catch(NullPointerException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select customer to update");
            alert.showAndWait();

        }

    }

    /**Method runs if Add Appointment button is pressed.  Program loads add appointment screen. */
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

    /**Method runs if Delete Appointment button is pressed.  If appointment is selected the appointment is deleted from program and DB. */
    @FXML
    void onActionMainScreenDeleteAppointmentButton(ActionEvent event) {

        try {
            Appointments selectedAppt = mainScreenAppointmentTableview.getSelectionModel().getSelectedItem();
            int apptId = selectedAppt.getApptId();
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            Alert alertConf = new Alert(Alert.AlertType.CONFIRMATION);

            if (selectedAppt != null) {
                alertConf.setTitle("Delete Appointment");
                alertConf.setContentText("Are you sure you wish to delete this appointment?");

                Optional<ButtonType> result = alertConf.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    DBAppointments.deleteAppointment(apptId);
                    mainScreenAppointmentTableview.setItems(DBAppointments.getAllAppointments());
                }

            }
        }
        catch (NullPointerException e){

            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setContentText("Appointment must be selected");
            alertError.showAndWait();
        }

    }

    /**Method runs if Update Appointment button is pressed. Program sends selected appointment to update appointment screen. */
    @FXML
    void onActionMainScreenUpdateAppointmentButton(javafx.event.ActionEvent actionEvent) throws IOException {

        try{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/UpdateAppointment.fxml"));
            loader.load();
            UpdateAppointment updateAppointmentController = loader.getController();
            Appointments a = mainScreenAppointmentTableview.getSelectionModel().getSelectedItem();



            updateAppointmentController.receiveAppointment(a);


            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }


        catch(NullPointerException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Must select appointment to update");
            alert.showAndWait();

        }

       /* stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/UpdateAppointment.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();*/

    }

    /**Method runs if Month radio button is pressed.  Program filters appointments by month. */
    @FXML
    void onActionMonthRB(ActionEvent event) {
        ObservableList<Appointments> monthList = FXCollections.observableArrayList();
        for(Appointments a : DBAppointments.getAllAppointments()){

            if(a.getStartTime().getMonth() == LocalDate.now().getMonth()){
                monthList.add(a);
            }

        }
        mainScreenAppointmentTableview.setItems(monthList);
    }

    /**Method runs if Week radio button is pressed.  Program filters appointments by week. */
    @FXML
    void onActionWeekRB(ActionEvent event) {
        ObservableList<Appointments> weekList = FXCollections.observableArrayList();
        for(Appointments a : DBAppointments.getAllAppointments()){

            if((a.getStartTime().getDayOfYear()/7) == (LocalDate.now().getDayOfYear()/7)){
                weekList.add(a);
            }

        }
        mainScreenAppointmentTableview.setItems(weekList);

    }

    /**Method runs if All radio button is pressed.  Program shows all appointments. */
    @FXML
    void onActionAllRB(ActionEvent event) {

        mainScreenAppointmentTableview.setItems(DBAppointments.getAllAppointments());

    }

    /**Method runs if monthly report combo is selected.  Report will display number of appointments. */
    @FXML
    void onActionReportAppointmentsMonthCombo(ActionEvent event) {

        System.out.println(reportAppointmentsMonthCombo.getValue());
        System.out.println(reportsAppointmentsTypeCombo.getValue());

        int apptCounter = 0;

        if(reportsAppointmentsTypeCombo.getValue() != null){

            for(Appointments a : DBAppointments.getAllAppointments()){



                if(a.getStartTime().getMonth().toString().equals(reportAppointmentsMonthCombo.getValue().toString())  && a.getApptType().toString().equals(reportsAppointmentsTypeCombo.getValue().toString()
                )){

                    System.out.println(a.getStartTime().getMonth());
                    System.out.println(a.getApptType());
                    apptCounter++;
                }
            }
        }

        reportsAppointmentsTxt.setText(String.valueOf(apptCounter));

    }

    @FXML
    void onActionReportsAppointmentsTxt(ActionEvent event) {

    }

    /**Method runs if type report combo is selected.  Report will display number of appointments. */
    @FXML
    void onActionReportsAppointmentsTypeCombo(ActionEvent event) {

        System.out.println(reportAppointmentsMonthCombo.getValue());
        System.out.println(reportsAppointmentsTypeCombo.getValue());

        int apptCounter = 0;

        if(reportAppointmentsMonthCombo.getValue() != null){

            for(Appointments a : DBAppointments.getAllAppointments()){



            if(a.getStartTime().getMonth().toString().equals(reportAppointmentsMonthCombo.getValue().toString())  && a.getApptType().toString().equals(reportsAppointmentsTypeCombo.getValue().toString())){

                System.out.println(a.getStartTime().getMonth());
            apptCounter++;}

            }

        }
        reportsAppointmentsTxt.setText(String.valueOf(apptCounter));
    }

    /**Method will run if schedule report combo is run.  Report will show a detailed schedule for each customer. */
    @FXML
    void onActionReportsScheduleCombo(ActionEvent event) {
        ObservableList <Appointments> sList= FXCollections.observableArrayList();

        for(Appointments a : DBAppointments.getAllAppointments()){

            if(a.getApptCustId() == reportsScheduleCombo.getValue().getCustId()){


                sList.add(a);
            }
        }

        reportsScheduleTableview.setItems(sList);
    }

    /**Method will run if country report combo is selected.  Report will show all customers in selected country. */
    @FXML
    void onActionReportsTotalCountryCombo(ActionEvent event) {

        int custCounter = 0;

        for(Customers c : DBCustomers.getAllCustomers()){

            if(c.getCustCntry().equals(reportsTotalCountryCombo.getValue())){

                custCounter++;
            }
        }

        reportsTotalTxt.setText(String.valueOf(custCounter));

    }

    @FXML
    void onActionReportsTotalTxt(ActionEvent event) {

    }



}
