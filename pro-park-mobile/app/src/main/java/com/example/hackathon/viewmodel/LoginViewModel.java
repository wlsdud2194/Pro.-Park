package com.example.hackathon.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.hackathon.model.Login;
import com.example.hackathon.network.client.LoginClient;
import com.example.hackathon.network.request.LoginRequest;

public class LoginViewModel extends BaseViewModel<Login> {

    private LoginClient loginClient;

    public LoginViewModel(Context context) {
        super(context);
        loginClient = new LoginClient();
    }

    public LiveData<Login> getResponse() {
        return data;
    }

    @SuppressLint("CheckResult")
    public void login(LoginRequest loginRequest) {

        addDisposable(loginClient.login(loginRequest),getDataObserver());
    }
}
