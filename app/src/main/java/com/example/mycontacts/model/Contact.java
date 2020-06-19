package com.example.mycontacts.model;

public class Contact {
    private int contactID;
    private String contactName;
    private String contactPhoneNumber;


    public Contact() {
    }

    public Contact(int contactID, String contactName, String contactPhoneNumber) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Contact(String contactName, String contactPhoneNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactID=" + contactID +
                ", contactName='" + contactName + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                '}';
    }

}
