package com.dl.server.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable{
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
