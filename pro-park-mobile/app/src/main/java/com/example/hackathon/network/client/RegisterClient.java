package com.example.hackathon.network.client;

import com.example.hackathon.Utils;
import com.example.hackathon.network.request.RegisterRequest;
import com.example.hackathon.network.response.Response;
import com.example.hackathon.network.retrofit.RegisterService;

import io.reactivex.Single;

public class RegisterClient extends NetworkClient {

    private RegisterService registerService;

    public RegisterClient() { registerService = Utils.RETROFIT.create(RegisterService.class); }

    public Single<String> register(RegisterRequest registerRequest) {

        return registerService.register(registerRequest).map(Response::getMessage);
    }
}
