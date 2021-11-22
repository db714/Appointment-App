package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    @Override
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
    void onActionLogin(ActionEvent event) {


    }

    @FXML
    void onActionPassword(ActionEvent event) {

    }

    @FXML
    void onActionUsername(ActionEvent event) {

    }

}



