package model;


public class Customers {

    int custId;
    String custName;
    String custAddress;
    String postCode;
    String phoneNum;
    String custDiv;
    String custCntry;

    public Customers(int custId, String custName, String custAddress, String postCode, String phoneNum, String custDiv, String custCntry){

        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.postCode = postCode;
        this.phoneNum = phoneNum;
        this.custDiv = custDiv;
        this.custCntry= custCntry;

    }
// getter for custId
    public int getCustId() {
        return custId;
    }
//getter for custName
    public String getCustName() {
        return custName;
    }
//getter for custAddress
    public String getCustAddress() {
        return custAddress;
    }
//getter for postCode
    public String getPostCode() {
        return postCode;
    }
//getter for phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }
//getter for divId
    public String getCustDiv() {
        return custDiv;
    }
//getter for cntryId
    public String getCustCntry() {
        return custCntry;
    }
}
