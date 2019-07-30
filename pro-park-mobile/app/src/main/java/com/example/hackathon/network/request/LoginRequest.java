package com.example.hackathon.network.request;


import com.example.hackathon.Utils;

import java.security.NoSuchAlgorithmException;

public class LoginRequest {

    private String id;

    private String pw;

    private String device;

    public LoginRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
        this.device = "mobile";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
