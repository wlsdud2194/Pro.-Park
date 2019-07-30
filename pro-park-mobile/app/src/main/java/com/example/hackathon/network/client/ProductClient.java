package com.example.hackathon.network.client;

import com.example.hackathon.Utils;
import com.example.hackathon.model.Product;
import com.example.hackathon.model.Products;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.retrofit.ProductService;

import java.util.List;

import io.reactivex.Single;

public class ProductClient extends NetworkClient {

    private ProductService productService;

    public ProductClient() { productService = Utils.RETROFIT.create(ProductService.class); }

    public Single<Products> getProduct(Token token) {

        return productService.getProduct(token.getToken()).map(response -> {

            if (response.body().getStatus() == 200) {

                Products products = new Products();

                products.setProduct(response.body().getData().getProduct());

                return products;
            }
            else {
                throw new Exception(response.body().getMessage());
            }
        });
    }
}
