package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class ChoiceViewModel extends BaseViewModel {

    public final MutableLiveData<String> value = new MutableLiveData<>();
    public final MutableLiveData<Boolean> check = new MutableLiveData<>();

    public ChoiceViewModel(Context context) {
        super(context);
    }
}
