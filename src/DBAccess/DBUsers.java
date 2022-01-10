package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUsers {


    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> userList = FXCollections.observableArrayList();

        try {

            String sql = "SELECT User_ID, User_Name FROM users;";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int usrId = rs.getInt("User_ID");
                String usrName = rs.getString("User_Name");

                Users u = new Users(usrId,usrName);
                userList.add(u);

            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    return userList;
    }


}
