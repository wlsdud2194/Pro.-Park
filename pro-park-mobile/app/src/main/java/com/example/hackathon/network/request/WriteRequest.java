package com.example.hackathon.network.request;

public class WriteRequest {

    private String productBarcode;

    private String content;

    public WriteRequest(String barcode, String contents) {
        this.productBarcode = barcode;
        this.content = contents;
    }

    public String getBarcode() {
        return productBarcode;
    }

    public void setBarcode(String barcode) {
        this.productBarcode = barcode;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String contents) {
        this.content = contents;
    }
}
