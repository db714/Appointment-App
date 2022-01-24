package model;

/**Class that defines objects and variables for customers.*/
public class Customers {

    int custId;
    String custName;
    String custAddress;
    String postCode;
    String phoneNum;
    String custDiv;
    String custCntry;

    /**Method that creates a customer object.
     @param custId
     @param custDiv
     @param custName
     @param phoneNum
     @param postCode
     @param custAddress
     @param custCntry */
    public Customers(int custId, String custName, String custAddress, String postCode, String phoneNum, String custDiv, String custCntry) {

        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.postCode = postCode;
        this.phoneNum = phoneNum;
        this.custDiv = custDiv;
        this.custCntry = custCntry;

    }

    /*public Customers(int custId, String custName){

        this.custId = custId;
        this.custName = custName;
    }*/

    /**Method retrieves custId
     @return custId */
// getter for custId
    public int getCustId() {
        return custId;
    }

    /**Method retrieves custName
     @return custName */
    //getter for custName
    public String getCustName() {
        return custName;
    }

    /**Method retrieves custAddress
     @return custAddress */
    //getter for custAddress
    public String getCustAddress() {
        return custAddress;
    }

    /**Method retrieves postCode
     @return postCode */
    //getter for postCode
    public String getPostCode() {
        return postCode;
    }

    /**Method retrieves phoneNum
     @return phoneNum */
    //getter for phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    /**Method retrieves custDiv
     @return custDiv */
    //getter for divId
    public String getCustDiv() {
        return custDiv;
    }

    /**Method retrieves custCntry
     @return custCntry */
    //getter for cntryId
    public String getCustCntry() {
        return custCntry;
    }


    /**Method converts customer object to string
     @return customer */
    @Override
    public String toString() {
        return (("#" + Integer.toString(custId) + " " + custName));
    }
}
