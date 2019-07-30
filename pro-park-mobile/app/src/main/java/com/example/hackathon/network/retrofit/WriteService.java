package com.example.hackathon.network.retrofit;

import androidx.annotation.NonNull;

import com.example.hackathon.network.request.RegisterRequest;
import com.example.hackathon.network.request.WriteRequest;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WriteService {

    @NonNull
    @POST("/comment")
    Single<Response> write(
            @Header("x-access-token") String token,
            @Body WriteRequest writeRequest);

}
