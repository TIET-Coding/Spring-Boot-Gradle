package com.myspringboot.demo.model;

import java.util.Date;

public class Teachers {

    private long TH_ID;
    private String FirstName;
    private String LastName;
    private String Qualification;
    private Date HireDate;
    private long SJ_ID;
    private long SCH_ID;

    public Teachers(long TH_ID, String firstName, String lastName, String qualification, Date hireDate, long SJ_ID, long SCH_ID) {
        this.TH_ID = TH_ID;
        FirstName = firstName;
        LastName = lastName;
        Qualification = qualification;
        HireDate = hireDate;
        this.SJ_ID = SJ_ID;
        this.SCH_ID = SCH_ID;
    }


    public long getTH_ID() {
        return TH_ID;
    }

    public void setTH_ID(long TH_ID) {
        this.TH_ID = TH_ID;
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

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public long getSJ_ID() {
        return SJ_ID;
    }

    public void setSJ_ID(long SJ_ID) {
        this.SJ_ID = SJ_ID;
    }

    public long getSCH_ID() {
        return SCH_ID;
    }

    public void setSCH_ID(long SCH_ID) {
        this.SCH_ID = SCH_ID;
    }
}
