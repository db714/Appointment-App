package controller;

import DBAccess.DBAppointments;
import DBAccess.DBCustomers;
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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

import model.*;

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

        try {
            Appointments selectedAppt = mainScreenAppointmentTableview.getSelectionModel().getSelectedItem();
            int apptId = selectedAppt.getApptId();
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            Alert alertConf = new Alert(Alert.AlertType.CONFIRMATION);

            if (selectedAppt != null) {
                alertConf.setTitle("Delete Customer");
                alertConf.setContentText("Are you sure you wish to delete this customer?");

                Optional<ButtonType> result = alertConf.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    DBAppointments.deleteAppointment(apptId);
                    mainScreenAppointmentTableview.setItems(DBAppointments.getAllAppointments());
                }

            }
        }
        catch (NullPointerException e){

            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setContentText("Customer must be selected");
            alertError.showAndWait();
        }

    }

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



}
