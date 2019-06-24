package com.nalan.movieapp.ui.viewmodel;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MovieDetailViewModelFactory implements ViewModelProvider.Factory {


    Activity activity;
    String newsId;

    public MovieDetailViewModelFactory(Activity activity,String newsId) {
        this.activity = activity;
        this.newsId=newsId;

    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom( MovieDetailViewModel.class)) {
            return (T) new  MovieDetailViewModel(activity,newsId);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
