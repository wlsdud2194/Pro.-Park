package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hackathon.model.Product;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.client.FindClient;

public class FindViewModel extends BaseViewModel<Product> {

    public Product product;
    public final MutableLiveData<String> value = new MutableLiveData<>();

    private FindClient findClient;

    public FindViewModel(Context context) {
        super(context);

        findClient = new FindClient();
    }

    public LiveData<Product> getResoponse() {
        return data;
    }

    public void find() {

        addDisposable(findClient.getProduct(getToken(), value.getValue()),getDataObserver());
    }

    public void like(Integer idx) {

        addDisposable(findClient.like(getToken(),idx),getBaseObserver());
    }
}
