package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

/**Class that defines objects and variables related to appointments.*/
public class Appointments {

    int apptId;
    String apptTitle;
    String apptDscrptn;
    String apptLctn;
    String apptType;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int apptCustId;
    int apptUsrId;
    int apptCntctId;

    /**Method that defines an appointment object.
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
    public Appointments( int apptId, String apptTitle, String apptDscrptn, String apptLctn, String apptType, LocalDateTime startTime, LocalDateTime endTime, int apptCustId, int apptUsrId, int apptCntctId){

        this.apptId = apptId;
        this.apptTitle = apptTitle;
        this.apptDscrptn = apptDscrptn;
        this.apptLctn = apptLctn;
        this.apptType = apptType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.apptCustId = apptCustId;
        this.apptUsrId = apptUsrId;
        this.apptCntctId = apptCntctId;



    }

    /**Method returns apptId
     @return apptId */
    //getter for apptId
    public int getApptId() {
        return apptId;
    }

    /**Method returns apptTitle
     @return apptTitle */
    //getter for apptTitle
    public String getApptTitle() {
        return apptTitle;
    }

    /**Method returns apptDscrptn
     @return appDscrptn */
    //getter for apptDescrptn
    public String getApptDscrptn() {
        return apptDscrptn;
    }

    /**Method returns appLctn
     @return apptLctn */
    //getter for apptLctn
    public String getApptLctn() {
        return apptLctn;
    }

    /**Method returns apptType
     @return apptType */
    //getter for apptType
    public String getApptType() {
        return apptType;
    }

    /**Method returns startTime
     @return startTime */
    //getter for startTime
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**Method returns endTime
     @return endTime */
    //getter for endTime
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**Method returns apptCustId
     @return apptCustId */
    //getter for apptCustId
    public int getApptCustId() {
        return apptCustId;
    }

    /**Method returns apptCntctId
     @return apptCntctId */
    //getter for apptCntctId
    public int getApptCntctId() {
        return apptCntctId;
    }

    /**Method returns apptUsrId
     @return apptUsrId */
    //getter for apptUsrID
    public int getApptUsrId() {
        return apptUsrId;
    }




    /**Method populates a list of times and stores in an observable list.
     @return tList */
    public static ObservableList<LocalTime> getTimes(){
        ObservableList<LocalTime> tList = FXCollections.observableArrayList();


        LocalTime start = LocalTime.of(1,00);
        LocalTime end = LocalTime.MIDNIGHT.minusHours(1);

        while(start.isBefore(end.plusSeconds(1))){
            tList.add(start);
            start = start.plusMinutes(30);

        }




     return tList;
    }


}
