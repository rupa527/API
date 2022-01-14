package com.example.api;

import com.example.api.model.ProductData;
import com.example.api.model.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JSONPlaceHolder {
    @GET("products")
    Call<Products> getProducts();

    @GET("products/1")
    Call<ProductData> getProductData(@Url String url);
}
