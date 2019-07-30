package com.example.hackathon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.hackathon.R;
import com.example.hackathon.databinding.WriteActivityBinding;
import com.example.hackathon.network.request.WriteRequest;
import com.example.hackathon.viewmodel.WriteViewModel;

public class WriteActivity extends BaseActivity<WriteActivityBinding, WriteViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.write_activity;
    }

    @Override
    protected Class viewModel() {
        return WriteViewModel.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        viewModel.value.setValue(intent.getStringExtra("value"));

        binding.barcodeText.setText(viewModel.value.getValue());

        viewModel.getSuccessMessage().observe(this, message -> {
            Intent goIntent = new Intent(this, FindActivity.class);
            goIntent.putExtra("barcode",viewModel.value.getValue());
            startActivity(goIntent);
        });

        viewModel.getErrorMessage().observe(this, error -> Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show());

        clickEvent();
    }

    private void clickEvent() {

        binding.go.setOnClickListener(v -> viewModel.write(new WriteRequest(viewModel.value.getValue(),binding.write.getText().toString())));
    }
}
