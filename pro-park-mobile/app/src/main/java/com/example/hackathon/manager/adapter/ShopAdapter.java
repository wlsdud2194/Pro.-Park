package com.example.hackathon.manager.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.activity.FindActivity;
import com.example.hackathon.manager.holder.ShopViewHolder;
import com.example.hackathon.model.Shop;
import com.example.hackathon.model.ShopList;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShopAdapter extends RecyclerView.Adapter<ShopViewHolder> {

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ShopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.binding.name.setText(ShopList.shopList.get(position).getName());
        holder.binding.price.setText(ShopList.shopList.get(position).getPrice() + "원");

        holder.setImage(ShopList.shopList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return ShopList.shopList.size();
    }
}
