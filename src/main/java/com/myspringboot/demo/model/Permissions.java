package com.myspringboot.demo.model;

public class Permissions {
    private long p_id;
    private String p_name;
    private String p_code;

    public Permissions(long p_id, String p_name, String p_code) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_code = p_code;
    }


    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }
}
