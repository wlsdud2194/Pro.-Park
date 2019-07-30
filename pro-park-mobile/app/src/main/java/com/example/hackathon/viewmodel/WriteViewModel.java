package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.hackathon.network.client.WriteClient;
import com.example.hackathon.network.request.WriteRequest;

public class WriteViewModel extends BaseViewModel {

    public final MutableLiveData<String> value = new MutableLiveData<>();

    private WriteClient writeClient;

    public WriteViewModel(Context context) {
        super(context);
        writeClient = new WriteClient();
    }

    public void write(WriteRequest writeRequest) {

        addDisposable(writeClient.write(getToken(),writeRequest),getBaseObserver());

    }
}
