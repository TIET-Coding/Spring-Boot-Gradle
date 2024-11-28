package com.myspringboot.demo.model;

public class RoleUser {
    private long id;
    private String user_id;
    private String role_id;
    private String create_date;
    private String create_by;
    private String update_date;
    private String update_by;

    public RoleUser(long id, String user_id, String role_id, String create_date, String create_by, String update_date, String update_by) {
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
        this.create_date = create_date;
        this.create_by = create_by;
        this.update_date = update_date;
        this.update_by = update_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
