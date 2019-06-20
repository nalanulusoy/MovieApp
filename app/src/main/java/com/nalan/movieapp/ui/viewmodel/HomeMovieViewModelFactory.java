package com.nalan.movieapp.ui.viewmodel;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeMovieViewModelFactory implements ViewModelProvider.Factory {


    Activity activity;

    public HomeMovieViewModelFactory(Activity activity) {
        this.activity = activity;

    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeMovieViewModel.class)) {
            return (T) new HomeMovieViewModel(activity);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }



}
