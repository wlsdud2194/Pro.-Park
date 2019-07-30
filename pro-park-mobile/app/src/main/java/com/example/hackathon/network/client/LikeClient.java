package com.example.hackathon.network.client;

import com.example.hackathon.Utils;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.request.LikeRequest;
import com.example.hackathon.network.response.Response;
import com.example.hackathon.network.retrofit.FindService;
import com.example.hackathon.network.retrofit.LikeService;

import io.reactivex.Single;

public class LikeClient {

    private LikeService likeService;

    public LikeClient() { likeService = Utils.RETROFIT.create(LikeService.class); }

    public Single<String> like(Token token, LikeRequest likeRequest) {

        return likeService.like(token.getToken(), likeRequest).map(Response::getMessage);
    }
}
