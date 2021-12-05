package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DBAppointments {


    public static ObservableList<Appointments> getAllAppointments(){

        ObservableList<Appointments> apptList = FXCollections.observableArrayList();

        try{

            //sql query
            String sql= "SELECT *\n FROM appointments;";

            //connecting and performing sql query
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            //placing results of query in result set
            ResultSet rs = ps.executeQuery(sql);

            //a while loop that moves cursor to next row in sql data
            while(rs.next()){

                int apptId = rs.getInt("Appointment_ID");
                String apptTitle = rs.getString("Title");
                String apptDscrptn = rs.getString("Description");
                String apptLctn = rs.getString("Location");
                String apptType = rs.getString("Type");
                LocalDateTime startTime = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime endTime = rs.getTimestamp("End").toLocalDateTime();
                int apptCustId = rs.getInt("Customer_ID");
                int apptUsrId = rs.getInt("User_ID");
                int apptCntctId = rs.getInt("Contact_ID");

                Appointments a = new Appointments(apptId, apptTitle, apptDscrptn, apptLctn, apptType, startTime, endTime, apptCustId, apptUsrId, apptCntctId);
                apptList.add(a);
            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }


    return apptList;
    }
}
