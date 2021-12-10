package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FirstLevelDivisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBFirstLevelDivisions {

    public static ObservableList<FirstLevelDivisions> getAllDivisions(int cID) {
        //this.cID = cID;
        ObservableList<FirstLevelDivisions> dList = FXCollections.observableArrayList();

        try {

            String sqlD = "SELECT Division_ID, Division\n" +
                    "FROM first_level_divisions\n" +
                    "WHERE COUNTRY_ID=" + cID + ";";

            PreparedStatement psD = JDBC.getConnection().prepareStatement(sqlD);

            ResultSet rsD = psD.executeQuery();

            while (rsD.next()) {

                int divisionID = rsD.getInt("Division_ID");
                String division = rsD.getString("Division");

                FirstLevelDivisions d = new FirstLevelDivisions(divisionID, division);
                dList.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dList;

    }

}
