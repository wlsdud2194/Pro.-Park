package com.example.hackathon.manager.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.activity.FindActivity;
import com.example.hackathon.activity.MainActivity;
import com.example.hackathon.manager.holder.ProductViewHolder;
import com.example.hackathon.manager.holder.ShopViewHolder;
import com.example.hackathon.model.Product;
import com.example.hackathon.model.ProductModel;
import com.example.hackathon.model.ShopList;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    List<ProductModel> list = new ArrayList<>();
    Context context;

    public ProductAdapter(List<ProductModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return  new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.binding.name.setText(list.get(position).getName());
        holder.binding.barcode.setText(list.get(position).getBarcode());

        holder.setImage(list.get(position).getImg());

        holder.binding.product.setOnClickListener(v -> {
            Intent goIntent = new Intent(context, FindActivity.class);
            goIntent.putExtra("barcode",list.get(position).getBarcode());
            context.startActivity(goIntent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
