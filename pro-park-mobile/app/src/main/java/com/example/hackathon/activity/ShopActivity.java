package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.databinding.ShopActivityBinding;
import com.example.hackathon.manager.adapter.ShopAdapter;
import com.example.hackathon.model.ShopList;
import com.example.hackathon.viewmodel.FindViewModel;

public class ShopActivity extends BaseActivity<ShopActivityBinding, FindViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.shop_activity;
    }

    @Override
    protected Class viewModel() {
        return FindViewModel.class;
    }

    private int allPrice = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < ShopList.shopList.size(); i++) {
            allPrice += Integer.parseInt(ShopList.shopList.get(i).getPrice());
        }

        binding.allPrice.setText("총 " + Integer.toString(allPrice) + "원");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        binding.recyclerView2.setLayoutManager(layoutManager);

        ShopAdapter shopAdapter = new ShopAdapter();
        binding.recyclerView2.setAdapter(shopAdapter);

        binding.back.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}
