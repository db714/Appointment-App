package model;

import java.time.LocalDateTime;

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

    //getter for apptId
    public int getApptId() {
        return apptId;
    }

    //getter for apptTitle
    public String getApptTitle() {
        return apptTitle;
    }

    //getter for apptDescrptn
    public String getApptDscrptn() {
        return apptDscrptn;
    }

    //getter for apptLctn
    public String getApptLctn() {
        return apptLctn;
    }

    //getter for apptType
    public String getApptType() {
        return apptType;
    }

    //getter for startTime
    public LocalDateTime getStartTime() {
        return startTime;
    }

    //getter for endTime
    public LocalDateTime getEndTime() {
        return endTime;
    }

    //getter for apptCustId
    public int getApptCustId() {
        return apptCustId;
    }

    //getter for apptCntctId
    public int getApptCntctId() {
        return apptCntctId;
    }

    //getter for apptUsrID
    public int getApptUsrId() {
        return apptUsrId;
    }
}
