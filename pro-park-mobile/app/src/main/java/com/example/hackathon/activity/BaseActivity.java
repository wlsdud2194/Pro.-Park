package com.example.hackathon.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.hackathon.viewmodel.ViewModelFactory;

public abstract class BaseActivity<VB extends ViewDataBinding, T extends ViewModel> extends AppCompatActivity {

    protected VB binding;
    protected T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId());
        viewModel = (T) ViewModelProviders.of(this, new ViewModelFactory(this)).get(viewModel());
    }

    @LayoutRes
    protected abstract int layoutId();

    protected abstract Class viewModel();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
    }
}
