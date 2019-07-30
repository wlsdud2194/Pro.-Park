package com.example.hackathon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    private String name;

    private String img;

    private String barcode;

    private List<Write> comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Write> getWrite() {
        return comment;
    }

    public void setWrite(List<Write> write) {
        this.comment = write;
    }
}
