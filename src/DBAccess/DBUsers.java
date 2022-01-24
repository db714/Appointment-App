package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Class that controls database operations for users.*/
public class DBUsers {


    /**Method uses SQL query to populate all users from database and stores them in an observable list. */
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


    /**Method uses SQL query to populate all secure users from database and stores them in an observable list. */
    public static ObservableList<Users> getSecureUsers(){
        ObservableList<Users> secureUsers = FXCollections.observableArrayList();

        try {

            String sql = "SELECT User_ID,User_Name,Password FROM users;";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int userId = rs.getInt("User_ID");
                String usrName = rs.getString("User_Name");
                String usrPassword = rs.getString("Password");

                Users u = new Users(userId,usrName,usrPassword);
                secureUsers.add(u);

            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return secureUsers;
    }



    }

