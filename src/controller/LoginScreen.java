package controller;

import DBAccess.DBAppointments;
import DBAccess.DBUsers;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

import lambdas.Message_Interface;
import lambdas.Notification_Interface;

import javafx.scene.control.*;
import model.Appointments;
import model.Users;

/** LoginScreen controller class that operates the login screen*/
public class LoginScreen implements Initializable {
    //@Override


    Stage stage;
    Parent scene;

    /**Upon initialize a lambda expression is called to convert a zoneId to string and output it. */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am initialized");

        Notification_Interface notification = curr -> {

            String result = curr.toString();
            return result;
        };


        zoneIDLabel.setText(notification.getMessage(ZoneId.systemDefault()));




            //If condition is true then language is changed to french on login screen
            if (Locale.getDefault().getLanguage().equals("fr")) {
                ResourceBundle rb = ResourceBundle.getBundle("languages/French", Locale.getDefault());
                usernameTxt.setPromptText(rb.getString("username"));
                passwordTxt.setPromptText(rb.getString("password"));
                loginButt.setText(rb.getString("login"));


            }

            else {
                return;
            }





    }

    @FXML
    private Button loginButt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    private Label zoneIDLabel;

    /**Method runs if login button is pressed.  Textfields are parsed and checked in DB to see if user exists.  If true then program opens Main Screen. */
    @FXML
    public void onActionLogin(javafx.event.ActionEvent actionEvent) throws IOException {

        try {

            String userName = usernameTxt.getText();
            String userPass = passwordTxt.getText();




            for (Users u : DBUsers.getSecureUsers()) {

                if ((u.getUsrName().contains(userName) && u.getPssWrd().contains(userPass)) && usernameTxt.getText().isEmpty() != true && passwordTxt.getText().isEmpty()!= true) {


                    stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    //telling program where we want it to go once button is clicked
                    scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
                    //program makes new scene
                    stage.setScene(new Scene(scene));
                    //new scene starts
                    stage.show();

                    System.out.println("User id is..." + u.getId());
                    appointmentReminder(u.getId());

                    loginRecord(userName,true);

                    return;




                }




            }

            ResourceBundle rb = ResourceBundle.getBundle("languages/French", Locale.getDefault());
            //if statement for french error box
            if(Locale.getDefault().getLanguage().equals("fr")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(rb.getString("error"));
                alert.setHeaderText(rb.getString("error"));
                alert.setContentText(rb.getString("lld"));
                //alert.setContentText(rb.getString("username")+rb.getString("or")+rb.getString("password")+rb.getString("is")+rb.getString("incorrect"));
                alert.showAndWait();

                loginRecord(userName,false);}
            //if statement for english error box
            if(Locale.getDefault().getLanguage().equals("en")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText("error");

                alert.setContentText("username or password is incorrect");
                alert.showAndWait();

                loginRecord(userName,false);}



        } catch (NullPointerException e) {

            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Fields cannot be blank");
            error.showAndWait();
        }
    }






    @FXML
    void onActionPassword(ActionEvent event) {

    }

    @FXML
    void onActionUsername(ActionEvent event) {

    }

    /**Method lets user know if they have an appointment within 15 minutes of system time. Lambda expression was written in an else statement to display a string. */
    public void appointmentReminder(int userID){
        System.out.println("method ID is..." + userID);

        int apptCounter = 0;
        String tempApptId="";
        String tempDate="";
        String tempTime="";


        for(Appointments a : DBAppointments.getAllAppointments()){

            if(userID == a.getApptUsrId()){



                LocalDateTime startTime = a.getStartTime();
                LocalDateTime currentTime = LocalDateTime.now();

                long timeDifference = ChronoUnit.MINUTES.between(currentTime,startTime);

                System.out.println(startTime);
                System.out.println(currentTime);
                System.out.println(timeDifference);

                if(timeDifference <= 15 && timeDifference >= 0){
                    apptCounter++;
                    tempApptId = Integer.toString(a.getApptId());
                    tempDate = a.getStartTime().toLocalDate().toString();
                    tempTime = a.getStartTime().toLocalTime().toString();
                }

            }


            }

        System.out.println(apptCounter);

        if(apptCounter > 0) {



            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointment Reminder");
            alert.setContentText("You have an appointment with the next 15 minutes\nAppt. Id: "+tempApptId +"\nDate: "+tempDate+"\nTime: "+tempTime);
            alert.showAndWait();
            return;
        }

        else{

            Message_Interface message = ()->{
                String sentence = "You have no appointments within 15 minutes";

                return sentence;
            };

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointment Reminder");
            alert.setContentText(message.getNotification());
            alert.showAndWait();

            return;
        }
    }

    /**Method sends a record of each login attempt to a text file name login_activity. @param usrName @param loginAttempt */
    public void loginRecord(String usrName, boolean loginAttempt) throws IOException {

        //Name file
        String filename = "login_activity.txt";

        //Scan for input
        Scanner keyboard = new Scanner(System.in);

        //Writes and appends input
        FileWriter fwriter = new FileWriter(filename, true);

        //Create and Open file
        PrintWriter outputFile = new PrintWriter(fwriter);

        if (loginAttempt == true) {

            outputFile.println(usrName + " " + LocalDate.now() + " " + LocalTime.now() + " successful");
        }

        if (loginAttempt == false) {

            outputFile.println(usrName + " " + LocalDate.now() + " " + LocalTime.now() + " failed");
        }


        //Close file
        outputFile.close();
    }







}



