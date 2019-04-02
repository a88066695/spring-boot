package com.boot.demo.entity;

import java.io.Serializable;

public class Notice implements Serializable {

    private static final long serialVersionUID = 210818469999970139L;

    private String id;

    private String context;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
