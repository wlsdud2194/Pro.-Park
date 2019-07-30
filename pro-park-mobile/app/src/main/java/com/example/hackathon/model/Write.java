package com.example.hackathon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Write {

    @SerializedName("idx")
    private int idx;
    @SerializedName("content")
    private String content;
    @SerializedName("writerId")
    private String writerId;
    @SerializedName("likeCount")
    private Integer likeCount;
    @SerializedName("like")
    private Integer like;
    @SerializedName("recomment")
    private List<Recomment> recomment;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String contents) {
        this.content = contents;
    }

    public String getWriter() {
        return writerId;
    }

    public void setWriter(String writer) {
        this.writerId = writer;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public List<Recomment> getRecomment() {
        return recomment;
    }

    public void setRecomment(List<Recomment> recomment) {
        this.recomment = recomment;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
