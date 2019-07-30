package com.example.hackathon.manager.holder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.databinding.ShopActivityBinding;
import com.example.hackathon.databinding.ShopItemBinding;
import com.example.hackathon.manager.adapter.ShopAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShopViewHolder extends RecyclerView.ViewHolder {

    public ShopItemBinding binding;

    public ShopViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);

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
