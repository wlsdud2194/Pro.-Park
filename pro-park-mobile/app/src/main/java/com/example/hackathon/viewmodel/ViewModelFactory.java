package com.example.hackathon.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Context context;

    public ViewModelFactory(Context context) {
        this.context = context;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass == LoginViewModel.class) {
            return (T) new LoginViewModel(context);
        } if (modelClass == RegisterViewModel.class) {
            return (T) new RegisterViewModel(context);
        } if (modelClass == MainViewModel.class) {
            return (T) new MainViewModel(context);
        } if (modelClass == ChoiceViewModel.class) {
            return (T) new ChoiceViewModel(context);
        } if (modelClass == WriteViewModel.class) {
            return (T) new WriteViewModel(context);
        } if (modelClass == FindViewModel.class) {
            return (T) new FindViewModel(context);
        } else {
            return super.create(modelClass);
        }
    }

}
