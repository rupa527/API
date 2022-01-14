package com.example.api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> productList;
    Context context;
    public static String PRODUCT_ID;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        productList = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productActivityIntent = new Intent(context, ProductActivity.class);
                String id = viewHolder.id.getText().toString();
                productActivityIntent.putExtra(ProductAdapter.PRODUCT_ID, id);
                context.startActivity(productActivityIntent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);
        holder.id.setText(product.getId());
        holder.name.setText(product.getName());
        holder.year.setText(product.getYear());
        holder.color.setText(product.getColor());
        holder.pant_one_value.setText(product.getPantone_value());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, year, color, pant_one_value;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);


            id = itemView.findViewById(R.id.id_tv);
            name = itemView.findViewById(R.id.name_tv);
            year = itemView.findViewById(R.id.year_tv);
            color = itemView.findViewById(R.id.color_tv);
            pant_one_value = itemView.findViewById(R.id.pant_one_value);


        }
    }
}
