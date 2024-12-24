package com.myspringboot.demo.model;

public class Schools {

    private long SCH_ID;
    private String SCH_Name;
    private String Address;
    private String ContactNumber;
    private String EstablishedYear;

    public Schools(long SCH_ID, String SCH_Name, String address, String contactNumber, String establishedYear) {
        this.SCH_ID = SCH_ID;
        this.SCH_Name = SCH_Name;
        this.Address = address;
        this.ContactNumber = contactNumber;
        this.EstablishedYear = establishedYear;
    }


    public long getSCH_ID() {
        return SCH_ID;
    }

    public void setSCH_ID(long SCH_ID) {
        this.SCH_ID = SCH_ID;
    }

    public String getSCH_Name() {
        return SCH_Name;
    }

    public void setSCH_Name(String SCH_Name) {
        this.SCH_Name = SCH_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEstablishedYear() {
        return EstablishedYear;
    }

    public void setEstablishedYear(String establishedYear) {
        EstablishedYear = establishedYear;
    }
}
