package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hackathon.R;
import com.example.hackathon.databinding.LoginActivityBinding;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.request.LoginRequest;
import com.example.hackathon.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<LoginActivityBinding, LoginViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected Class viewModel() {
        return LoginViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (viewModel.getToken().getToken() != "") {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        viewModel.getErrorMessage().observe(this, error -> Toast.makeText(this, error, Toast.LENGTH_LONG).show());

        viewModel.getResponse().observe(this, user -> {
            Token token = new Token(this);
            token.setToken(user.getToken());

            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        clickEvent();
    }

    private void clickEvent() {

        clickLoginBtn();
        clickRegisterBtn();
    }

    private void clickLoginBtn() {

        binding.loginBtn.setOnClickListener(v ->
                viewModel.login(new LoginRequest(binding.idText.getText().toString(), binding.passwordText.getText().toString())));
    }

    private void clickRegisterBtn() {

        binding.registerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

            startActivity(intent);
        });
    }
}
