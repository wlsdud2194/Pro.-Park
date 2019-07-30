package com.example.hackathon.manager.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.databinding.ProductItemBinding;
import com.example.hackathon.databinding.ShopItemBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ProductItemBinding binding;
    public View view;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
        view = itemView;

    }

    public void setImage(String img) {

        new setPhotoTask().execute(img);

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
            binding.img.setImageBitmap(bmImg);
        }

    }
}
