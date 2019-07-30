package com.example.hackathon.model;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

public class Token extends ContextWrapper {

    public Token(Context context) {
        super(context);
    }

    private String token;

    public void setToken(String token) {

        SharedPreferences sharedPreferences = getSharedPreferences("hackathon",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("token", token);

        editor.commit();
    }

    public String getToken() {

        SharedPreferences sharedPreferences = getSharedPreferences("hackathon",MODE_PRIVATE);

        token = sharedPreferences.getString("token","");

        return token;

    }
}
