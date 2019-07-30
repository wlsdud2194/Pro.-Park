package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hackathon.model.Product;
import com.example.hackathon.model.Products;
import com.example.hackathon.network.client.ProductClient;

import java.util.List;

public class MainViewModel extends BaseViewModel<Products> {

    public final MutableLiveData<String> number = new MutableLiveData<>();
    private ProductClient productClient;

    public MainViewModel(Context context) {
        super(context);
        productClient = new ProductClient();
    }

    public void getProduct() {

        addDisposable(productClient.getProduct(getToken()),getDataObserver());
    }
}
