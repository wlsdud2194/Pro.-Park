package com.example.hackathon.network.client;


import com.example.hackathon.Utils;
import com.example.hackathon.model.Login;
import com.example.hackathon.network.request.LoginRequest;
import com.example.hackathon.network.retrofit.LoginService;

import org.json.JSONObject;

import java.util.Objects;

import io.reactivex.Single;

public class LoginClient extends NetworkClient{

    private LoginService loginService;

    public LoginClient() { loginService = Utils.RETROFIT.create(LoginService.class); }

    public Single<Login> login(LoginRequest loginRequest) {

        return loginService.login(loginRequest).map(response -> {

            if (!response.isSuccessful()) {
                JSONObject errorBody = new JSONObject(Objects
                        .requireNonNull(
                                response.errorBody()).string());

                throw new Exception(errorBody.getString("message"));
            }

            if (response.body().getStatus() == 200) {

                Login login = new Login();

                login.setToken(response.body().getData().getToken());

                return login;
            }
            else if (response.body().getStatus() == 401) {

                throw new Exception("아이디 또는 비밀번호가 틀렸습니다");
            }
            else {

                throw new Exception(response.body().getMessage());
            }

        });

    }
}
