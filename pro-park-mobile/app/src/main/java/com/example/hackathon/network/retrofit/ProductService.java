package com.example.hackathon.network.retrofit;

import com.example.hackathon.model.Product;
import com.example.hackathon.model.Products;
import com.example.hackathon.network.response.Response;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ProductService {

    @GET("/product/")
    Single<retrofit2.Response<Response<Products>>> getProduct(@Header("x-access-token") String token);
}
