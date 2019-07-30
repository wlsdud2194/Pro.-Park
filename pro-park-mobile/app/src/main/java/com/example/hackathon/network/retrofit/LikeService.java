package com.example.hackathon.network.retrofit;

import androidx.annotation.NonNull;

import com.example.hackathon.network.request.LikeRequest;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LikeService {

    @NonNull
    @POST("/comment/toggle")
    Single<Response> like(@Header("x-access-token") String token, @Body LikeRequest likeRequest);

}
