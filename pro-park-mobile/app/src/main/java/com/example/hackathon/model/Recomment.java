package com.example.hackathon.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Recomment {

    private int idx;

    @SerializedName("writerId")
    private String writer;

    @SerializedName("content")
    private String contents;

    @SerializedName("writeDate")
    private Date writeDate;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
