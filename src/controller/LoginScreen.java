package controller;

import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Optional;
import javafx.scene.control.*;



public class LoginScreen implements Initializable {
    //@Override


    Stage stage;
    Parent scene;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am initialized");


    }

    @FXML
    private Button loginButt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField usernameTxt;

    @FXML
    public void onActionLogin(javafx.event.ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //program makes new scene
        stage.setScene(new Scene(scene));
        //new scene starts
        stage.show();


    }

    @FXML
    void onActionPassword(ActionEvent event) {

    }

    @FXML
    void onActionUsername(ActionEvent event) {

    }

}



