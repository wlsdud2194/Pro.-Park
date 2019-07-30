package com.example.hackathon.model;

public class Shop {

    String img;

    String price;

    String name;

    public Shop(String img, String price, String name) {
        this.img = img;
        this.price = price;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
