package model;

/**Class defines objects and variables related to contacts.*/
public class Contacts {

    int contactId;
    String contactName;
    String contactEmail;

    /**Method that defines a contact object.
     @param contactId
     @param contactName
     @param contactEmail */
    public Contacts(int contactId, String contactName, String contactEmail) {

        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**Method that defines another contact object.
     @param contactId
     @param contactName */
    public Contacts(int contactId, String contactName) {

        this.contactId = contactId;
        this.contactName = contactName;
    }

    /**Method that retrieves contactId.
     @return contactId */
    //getter for contactId
    public int getContactId() {
        return contactId;
    }

    /**Method that retrieves contactName.
     @return contactName */
    //getter for contactName
    public String getContactName() {
        return contactName;
    }

    /**Method that retrieves contactEmail.
     @return contactEmail */
    //getter for contactEmail
    public String getContactEmail() {
        return contactEmail;
    }

    /**Method that displays contact object as string.
     @return contact */
    @Override
    public String toString() {
        return ((/*"#" + Integer.toString(contactId) + " " + */contactName));
    }
}
