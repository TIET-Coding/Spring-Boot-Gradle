package com.myspringboot.demo.model;

import java.util.Date;

public class Role {
    private long r_id;
    private String r_name;
    private String r_code;
    private String discription;
    private Date create_date;
    private String create_by;
    private Date update_date;
    private String update_by;

    public Role(long r_id, String r_name, String r_code, String discription, Date create_date, String create_by, Date update_date, String update_by) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_code = r_code;
        this.discription = discription;
        this.create_date = create_date;
        this.create_by = create_by;
        this.update_date = update_date;
        this.update_by = update_by;
    }

    public long getR_id() {
        return r_id;
    }

    public void setR_id(long r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_code() {
        return r_code;
    }

    public void setR_code(String r_code) {
        this.r_code = r_code;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
