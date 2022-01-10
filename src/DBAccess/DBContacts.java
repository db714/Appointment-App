package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContacts {

    public static ObservableList<Contacts> getAllContacts() {
        ObservableList<Contacts> contactList = FXCollections.observableArrayList();

        try {

            String sql = "SELECT Contact_ID, Contact_Name FROM contacts;";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Integer contactId = rs.getInt("Contact_ID");
                String contactName = rs.getString("Contact_Name");

                Contacts c = new Contacts(contactId, contactName);
                contactList.add(c);

            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return contactList;
    }
}
