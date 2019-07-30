package com.example.hackathon.network.retrofit;

import androidx.annotation.NonNull;

import com.example.hackathon.model.Login;
import com.example.hackathon.network.request.LoginRequest;
import com.example.hackathon.network.request.RegisterRequest;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterService {

    @NonNull
    @POST("/auth/register")
    Single<Response> register(@Body RegisterRequest registerRequest);
}
