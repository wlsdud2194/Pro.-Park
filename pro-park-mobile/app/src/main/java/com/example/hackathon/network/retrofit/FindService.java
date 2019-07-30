package com.example.hackathon.network.retrofit;

import androidx.annotation.NonNull;

import com.example.hackathon.model.Product;
import com.example.hackathon.network.response.Response;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FindService {

    @GET("/product/{barcode}")
    Single<retrofit2.Response<Response<Product>>> getProduct(
            @Header("x-access-token") String token,
            @Path("barcode") String barcode
    );

    @NonNull
    @POST("/comment/toggle")
    Single<Response> like(
            @Header("x-access-token") String token,
            @Body Integer postIdx);

}
