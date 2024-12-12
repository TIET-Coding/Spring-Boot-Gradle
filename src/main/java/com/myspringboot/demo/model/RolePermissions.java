package com.myspringboot.demo.model;

public class RolePermissions {
    private long role_p_id;
    private String r_id;
    private long p_id;

    public RolePermissions(long role_p_id, String r_id, long p_id) {
        this.role_p_id = role_p_id;
        this.r_id = r_id;
        this.p_id = p_id;
    }

    public long getRole_p_id() {
        return role_p_id;
    }

    public void setRole_p_id(long role_p_id) {
        this.role_p_id = role_p_id;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }
}
