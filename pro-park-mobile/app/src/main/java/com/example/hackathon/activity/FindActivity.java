package com.example.hackathon.activity;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.databinding.FindActivityBinding;
import com.example.hackathon.manager.adapter.FindAdapter;
import com.example.hackathon.model.Product;
import com.example.hackathon.model.Shop;
import com.example.hackathon.model.ShopList;
import com.example.hackathon.model.Write;
import com.example.hackathon.viewmodel.FindViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindActivity extends BaseActivity<FindActivityBinding, FindViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.find_activity;
    }

    @Override
    protected Class viewModel() {
        return FindViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent.getStringExtra("barcode") != null) {
            viewModel.value.setValue(intent.getStringExtra("barcode"));
        }

        binding.question.setVisibility(View.INVISIBLE);
        binding.editText.setVisibility(View.INVISIBLE);
        binding.barcode.setText(viewModel.value.getValue());

        viewModel.find();

        viewModel.getResoponse().observe(this, product -> {
            viewModel.product = product;
            binding.name.setText(viewModel.product.getName());
            setImage();
            connetRecyclerView(viewModel.product.getWrite());
        });

        clickEvent();
    }

    private void connetRecyclerView(List<Write> list) {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        binding.recyclerView.setLayoutManager(layoutManager);

        FindAdapter findAdapter = new FindAdapter(list,this,this, viewModel.value.getValue());
        binding.recyclerView.setAdapter(findAdapter);

    }

    private void setImage() {

        if (viewModel.product.getImg() != null) {
            new setPhotoTask().execute(viewModel.product.getImg());
        }

    }


    private class setPhotoTask extends AsyncTask<String, Integer, Bitmap> {

        private Bitmap bmImg;

        @Override
        protected Bitmap doInBackground(String... urls) {

            try{
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();

                InputStream is = conn.getInputStream();

                bmImg = BitmapFactory.decodeStream(is);


            }catch(IOException e){
                e.printStackTrace();
            }
            return bmImg;
        }

        protected void onPostExecute(Bitmap img){
            binding.imageView.setImageBitmap(bmImg);
        }

    }

    private void clickEvent() {

        binding.back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.shop.setOnClickListener(v -> {
            binding.question.setVisibility(View.VISIBLE);
            binding.editText.setVisibility(View.VISIBLE);
        });

        binding.no.setOnClickListener(v -> {
            binding.question.setVisibility(View.INVISIBLE);
            binding.editText.setVisibility(View.INVISIBLE);
        });

        binding.yes.setOnClickListener(v -> {

            ShopList.shopList.add(new Shop(viewModel.product.getImg(), binding.editText.getText().toString(), viewModel.product.getName()));

            binding.question.setVisibility(View.INVISIBLE);
            binding.editText.setVisibility(View.INVISIBLE);

            Toast.makeText(this, "장바구니에 등록했습니다", Toast.LENGTH_SHORT).show();
        });
    }
}
