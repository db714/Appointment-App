package main;
//package helper;


import helper.DBQuery;
import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/** Main Class.*/
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        stage.setTitle("");
        stage.setScene(new Scene(root, 350, 250));
        stage.show();
    }
/**Main method that runs the program. */
    public static void main(String[] args) throws SQLException {

        Connection conn = JDBC.openConnection();

        DBQuery.setStatement(conn); //Create Statement Object
        Statement statement = DBQuery.getStatement(); //Get Statement reference

        //Raw SQL insert statement
        String insertStatement = "INSERT INTO countries(Country,Create_Date,Created_By,Last_Updated_By) VALUES('US','2021-11-30 00:00:00','admin','admin')";

        //Execute SQL statement
        statement.execute(insertStatement);

        //Confirm rows affected
        if(statement.getUpdateCount() > 0)
            System.out.println(statement.getUpdateCount() + " rows(s) affected!");
        else
            System.out.println("no change");


        launch(args);

        JDBC.closeConnection();
    }
}
