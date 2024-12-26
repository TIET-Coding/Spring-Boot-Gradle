package com.myspringboot.demo.model;

public class Subjects {
    private long SJ_ID;
    private String SJ_Name;
    private String Description;

    public Subjects(long SJ_ID, String SJ_Name, String description) {
        this.SJ_ID = SJ_ID;
        this.SJ_Name = SJ_Name;
        Description = description;
    }

    public long getSJ_ID() {
        return SJ_ID;
    }

    public void setSJ_ID(long SJ_ID) {
        this.SJ_ID = SJ_ID;
    }

    public String getSJ_Name() {
        return SJ_Name;
    }

    public void setSJ_Name(String SJ_Name) {
        this.SJ_Name = SJ_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
