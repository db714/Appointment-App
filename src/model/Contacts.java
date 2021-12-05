package model;

public class Contacts {

    int contactId;
    String contactName;
    String contactEmail;

    public Contacts(int contactId, String contactName, String contactEmail){

        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    //getter for contactId
    public int getContactId() {
        return contactId;
    }

    //getter for contactName
    public String getContactName() {
        return contactName;
    }

    //getter for contactEmail
    public String getContactEmail() {
        return contactEmail;
    }
}
