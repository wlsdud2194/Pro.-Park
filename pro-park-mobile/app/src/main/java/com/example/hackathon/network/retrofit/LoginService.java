package com.example.hackathon.network.retrofit;

import androidx.annotation.NonNull;
import com.example.hackathon.model.Login;
import com.example.hackathon.network.request.LoginRequest;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @NonNull
    @POST("/auth/login")
    Single<retrofit2.Response<Response<Login>>> login(@Body LoginRequest loginRequest);
}
