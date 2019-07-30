package com.example.hackathon.network.request;

import com.example.hackathon.Utils;

import java.security.NoSuchAlgorithmException;

public class RegisterRequest {

    private String id;

    private String pw;

    private String phone;

    private String name;

    private String device;

    public RegisterRequest(String id, String pw, String phone, String name) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
