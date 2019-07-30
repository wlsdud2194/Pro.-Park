package com.example.hackathon.network.client;

import com.example.hackathon.Utils;
import com.example.hackathon.model.Product;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.response.Response;
import com.example.hackathon.network.retrofit.FindService;

import io.reactivex.Single;

public class FindClient extends NetworkClient {

    private FindService findService;

    public FindClient() { findService = Utils.RETROFIT.create(FindService.class); }

    public Single<Product> getProduct(Token token, String barcode) {

        return findService.getProduct(token.getToken(), barcode).map(response -> {

            if (response.body().getStatus() == 200) {

                Product product = new Product();

                product.setBarcode(response.body().getData().getBarcode());
                product.setImg(response.body().getData().getImg());
                product.setName(response.body().getData().getName());
                product.setWrite(response.body().getData().getWrite());

                return product;
            }
            else {
                throw new Exception(response.body().getMessage());
            }
        });
    }

    public Single<String> like(Token token, Integer idx) {

        return findService.like(token.getToken(), idx).map(Response::getMessage);
    }
}
