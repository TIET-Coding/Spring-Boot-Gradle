package com.myspringboot.demo.model;

public class Classes {
    private long CL_ID;
    private String CL_Name;
    private long TH_ID;
    private long SCH_ID;

    public Classes(long CL_ID, String CL_Name, long TH_ID, long SCH_ID) {
        this.CL_ID = CL_ID;
        this.CL_Name = CL_Name;
        this.TH_ID = TH_ID;
        this.SCH_ID = SCH_ID;
    }


    public long getCL_ID() {
        return CL_ID;
    }

    public void setCL_ID(long CL_ID) {
        this.CL_ID = CL_ID;
    }

    public String getCL_Name() {
        return CL_Name;
    }

    public void setCL_Name(String CL_Name) {
        this.CL_Name = CL_Name;
    }

    public long getTH_ID() {
        return TH_ID;
    }

    public void setTH_ID(long TH_ID) {
        this.TH_ID = TH_ID;
    }

    public long getSCH_ID() {
        return SCH_ID;
    }

    public void setSCH_ID(long SCH_ID) {
        this.SCH_ID = SCH_ID;
    }
}
