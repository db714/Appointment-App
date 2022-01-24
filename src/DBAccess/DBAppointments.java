package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**Class that controls the database operations for the appointments.*/
public class DBAppointments {


    /**Method uses SQL query to grab all appointments in the database and places them inside an observable list. @return apptList */
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

    /**Method uses SQL query to add new appointments to database.
      @param apptId
     @param apptTitle
     @param apptDscrptn
     @param apptLctn
     @param apptType
     @param startTime
     @param endTime
     @param apptCustId
     @param apptUsrId
     @param apptCntctId
      */
    public static void createAppointment(int apptId, String apptTitle, String apptDscrptn, String apptLctn, String apptType, LocalDateTime startTime, LocalDateTime endTime, int apptCustId, int apptUsrId, int apptCntctId){

        try{
            String sqlCA = "INSERT INTO appointments VALUES(NULL,?,?,?,?,?,?,NULL,NULL,CURRENT_TIMESTAMP ,NULL,?,?,?);";

            PreparedStatement psCA = JDBC.getConnection().prepareStatement(sqlCA);

        psCA.setString(1,apptTitle);
        psCA.setString(2,apptDscrptn);
        psCA.setString(3,apptLctn);
        psCA.setString(4,apptType);
        psCA.setTimestamp(5, Timestamp.valueOf(startTime));
        psCA.setTimestamp(6, Timestamp.valueOf(endTime));
        psCA.setInt(7,apptCustId);
        psCA.setInt(8,apptUsrId);
        psCA.setInt(9,apptCntctId);

        psCA.execute();

        }

        catch(SQLException e){
            e.printStackTrace();
        }

    }

    //when creating appointments
    // you'll need to add info to the customer first so that the customer id
    // will maintain referential integrity in the database (key to keys 40 minute mark)


    /**Method uses SQL query to delete appointment from database.
     * @param apptId */
    public static void deleteAppointment(int apptId){

        try{
        String sqlDA = "DELETE from appointments WHERE Appointment_ID = ?";

        PreparedStatement psDA = JDBC.getConnection().prepareStatement(sqlDA);

        psDA.setInt(1, apptId);

        psDA.execute();


        }

        catch (SQLException e){
            e.printStackTrace();
        }


    }

    /**Method uses SQL query to modify an existing appointment from  database.
     @param apptId
     @param apptTitle
     @param apptDscrptn
     @param apptLctn
     @param apptType
     @param startTime
     @param endTime
     @param apptCustId
     @param apptUsrId
     @param apptCntctId */
    public static void modifyAppointment(int apptId, String apptTitle, String apptDscrptn, String apptLctn, String apptType, LocalDateTime startTime, LocalDateTime endTime, int apptCustId, int apptUsrId, int apptCntctId){

        try{
            String sqlUA = "UPDATE appointments SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?;";

            PreparedStatement psUA = JDBC.getConnection().prepareStatement(sqlUA);

            psUA.setString(1,apptTitle);
            psUA.setString(2,apptDscrptn);
            psUA.setString(3,apptLctn);
            psUA.setString(4,apptType);
            psUA.setTimestamp(5, Timestamp.valueOf(startTime));
            psUA.setTimestamp(6, Timestamp.valueOf(endTime));
            psUA.setInt(7,apptCustId);
            psUA.setInt(8,apptUsrId);
            psUA.setInt(9,apptCntctId);
            psUA.setInt(10,apptId);

            psUA.execute();

        }

        catch(SQLException e){
            e.printStackTrace();
        }

    }



}
