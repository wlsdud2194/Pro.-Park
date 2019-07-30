package com.example.hackathon.model;

import java.util.ArrayList;
import java.util.List;

public class ShopList {

    public static List<Shop> shopList = new ArrayList<>();

    public static List<Shop> getShopList() {
        return shopList;
    }

    public static void setShopList(List<Shop> shopList) {
        ShopList.shopList = shopList;
    }
}
