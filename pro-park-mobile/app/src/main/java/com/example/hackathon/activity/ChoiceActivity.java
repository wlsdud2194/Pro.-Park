package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.ChoiceActivityBinding;
import com.example.hackathon.viewmodel.ChoiceViewModel;

public class ChoiceActivity extends BaseActivity<ChoiceActivityBinding, ChoiceViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.choice_activity;
    }

    @Override
    protected Class viewModel() {
        return ChoiceViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        viewModel.value.setValue(intent.getStringExtra("value"));

        viewModel.check.setValue(true);

        checkManage(true);

        viewModel.check.observe(this, check -> {
            checkManage(check);
        });

        clickEvent();
    }

    private void checkManage(Boolean check) {

        if (check) {
            binding.write.setImageDrawable(getDrawable(R.drawable.ic_create_black_24dp_2));
            binding.read.setImageDrawable(getDrawable(R.drawable.ic_search_black_24dp));
            binding.writeText.setTextColor(binding.writeText.getResources().getColor(R.color.colorPrimary));
            binding.readText.setTextColor(binding.readText.getResources().getColor(R.color.white));
        }
        else {
            binding.write.setImageDrawable(getDrawable(R.drawable.ic_create_black_24dp));
            binding.read.setImageDrawable(getDrawable(R.drawable.ic_search_black_24dp_2));
            binding.writeText.setTextColor(binding.writeText.getResources().getColor(R.color.white));
            binding.readText.setTextColor(binding.readText.getResources().getColor(R.color.colorPrimary));
        }
    }

    private void clickEvent() {

        binding.read.setOnClickListener(v -> viewModel.check.setValue(false));
        binding.write.setOnClickListener(v -> viewModel.check.setValue(true));

        binding.back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.go.setOnClickListener(v -> {

            Intent intent;

            if (viewModel.check.getValue()) {
                intent = new Intent(this,WriteActivity.class);
                intent.putExtra("value",viewModel.value.getValue());
            }
            else {
                intent = new Intent(this,FindActivity.class);
                intent.putExtra("barcode",viewModel.value.getValue());
            }

            startActivity(intent);
        });
    }
}
