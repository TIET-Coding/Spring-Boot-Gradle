package com.myspringboot.demo.model;

public class User {
    private long user_id;
    private String username;
    private String branch;
    private String position;
    private String phone;
    private String email;

    public User(long user_id, String username, String branch, String position, String phone, String email) {
        this.user_id = user_id;
        this.username = username;
        this.branch = branch;
        this.position = position;
        this.phone = phone;
        this.email = email;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
