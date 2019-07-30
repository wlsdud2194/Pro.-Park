package com.example.hackathon.manager.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.databinding.FindItemBinding;

public class FindViewHolder extends RecyclerView.ViewHolder {

    public FindItemBinding binding;

    public FindViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
    }
}
