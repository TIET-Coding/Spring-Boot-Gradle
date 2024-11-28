package com.myspringboot.demo.model;

public class Master {
    private long id;
    private String code;
    private String name;
    private String caption;
    private String status;
    private String type;

    public Master(long id, String code, String name, String caption, String status, String type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.caption = caption;
        this.status = status;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
