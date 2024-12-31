package com.myspringboot.demo.model;

import java.math.BigDecimal;

public class Grades {
    private long G_ID;
    private long SD_ID;
    private long SJ_ID;
    private BigDecimal Marks;
    private String Grade;

    public Grades(long g_ID, long SD_ID, long SJ_ID, BigDecimal marks, String grade) {
        G_ID = g_ID;
        this.SD_ID = SD_ID;
        this.SJ_ID = SJ_ID;
        Marks = marks;
        Grade = grade;
    }


    public long getG_ID() {
        return G_ID;
    }

    public void setG_ID(long g_ID) {
        G_ID = g_ID;
    }

    public long getSD_ID() {
        return SD_ID;
    }

    public void setSD_ID(long SD_ID) {
        this.SD_ID = SD_ID;
    }

    public long getSJ_ID() {
        return SJ_ID;
    }

    public void setSJ_ID(long SJ_ID) {
        this.SJ_ID = SJ_ID;
    }

    public BigDecimal getMarks() {
        return Marks;
    }

    public void setMarks(BigDecimal marks) {
        Marks = marks;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}
