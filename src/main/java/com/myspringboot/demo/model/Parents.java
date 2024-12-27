package com.myspringboot.demo.model;

public class Parents {
    private long P_ID;
    private String FirstName;
    private String LastName;
    private String ContactNumber;
    private String Email;

    public Parents(long p_ID, String firstName, String lastName, String contactNumber, String email) {
        P_ID = p_ID;
        FirstName = firstName;
        LastName = lastName;
        ContactNumber = contactNumber;
        Email = email;
    }


    public long getP_ID() {
        return P_ID;
    }

    public void setP_ID(long p_ID) {
        P_ID = p_ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
