package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.hackathon.network.client.RegisterClient;
import com.example.hackathon.network.request.RegisterRequest;

public class RegisterViewModel extends BaseViewModel<String> {

    RegisterClient registerClient;

    public RegisterViewModel(Context context) {
        super(context);
        registerClient = new RegisterClient();
    }

    public void register(RegisterRequest registerRequest) {

        addDisposable(registerClient.register(registerRequest),getBaseObserver());
    }
}
