package com.myspringboot.demo.model;

import java.util.Date;

public class Attendance {
    private long A_ID;
    private long SD_ID;
    private long CL_ID;
    private String Date;
    private String Status;

    public Attendance(long a_ID, long SD_ID, long CL_ID, String date, String status) {
        A_ID = a_ID;
        this.SD_ID = SD_ID;
        this.CL_ID = CL_ID;
        Date = date;
        Status = status;
    }


    public long getA_ID() {
        return A_ID;
    }

    public void setA_ID(long a_ID) {
        A_ID = a_ID;
    }

    public long getSD_ID() {
        return SD_ID;
    }

    public void setSD_ID(long SD_ID) {
        this.SD_ID = SD_ID;
    }

    public long getCL_ID() {
        return CL_ID;
    }

    public void setCL_ID(long CL_ID) {
        this.CL_ID = CL_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
