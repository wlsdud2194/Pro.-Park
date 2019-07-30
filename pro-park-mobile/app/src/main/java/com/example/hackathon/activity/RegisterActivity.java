package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.RegisterActivityBinding;
import com.example.hackathon.network.request.RegisterRequest;
import com.example.hackathon.viewmodel.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterActivityBinding, RegisterViewModel>{

    @Override
    protected int layoutId() {
        return R.layout.register_activity;
    }

    @Override
    protected Class viewModel() {
        return RegisterViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.getSuccessMessage().observe(this, message -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        });

        viewModel.getErrorMessage().observe(this, message -> {
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        });

        clickEvent();
    }

    private void clickEvent() {

        binding.registerBtn.setOnClickListener(v -> viewModel.register(new RegisterRequest(binding.idText.getText().toString(),
                binding.passwordText.getText().toString(),
                binding.phoneText.getText().toString(),
                binding.nameText.getText().toString())));

        binding.back.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
