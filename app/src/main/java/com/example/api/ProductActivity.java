package com.example.api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api.model.Product;
import com.example.api.model.ProductData;
import com.example.api.model.Support;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        setTitle("Product Details");

        Intent intent = getIntent();
        String productId = intent.getStringExtra(ProductAdapter.PRODUCT_ID);

        TextView textViewProductId = findViewById(R.id.productId);
        TextView textViewProductName = findViewById(R.id.productName);
        TextView textViewProductYear = findViewById(R.id.productYear);
        TextView textViewProductColor = findViewById(R.id.productColor);
        TextView textViewProductPantoneValue = findViewById(R.id.productPantoneValue);
        TextView textViewSupportUrl = findViewById(R.id.supportUrl);
        TextView textViewSupportText = findViewById(R.id.supportText);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/products/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceHolder jsonPlaceHolder = retrofit.create(JSONPlaceHolder.class);
        Call<ProductData> call = jsonPlaceHolder.getProductData(productId);
        call.enqueue(new Callback<ProductData>() {
            @Override
            public void onResponse(Call<ProductData> call, Response<ProductData> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ProductActivity.this, response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                Product product = response.body().data;
                Support support = response.body().support;
                if(product != null){
                    textViewProductId.setText(product.id);
                    textViewProductName.setText(product.name);
                    textViewProductYear.setText(product.year);
                    textViewProductColor.setText(product.color);
                    textViewProductPantoneValue.setText(product.pantone_value);
                }
                if (support != null){
                    textViewSupportUrl.setText(support.url);
                    textViewSupportText.setText(support.text);
                }
            }

            @Override
            public void onFailure(Call<ProductData> call, Throwable t) {
                Toast.makeText(ProductActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}


