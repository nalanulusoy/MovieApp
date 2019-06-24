package com.nalan.movieapp.ui.viewmodel;

import android.app.Activity;
import android.widget.Toast;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.util.ActivityUtils;
import com.nalan.movieapp.util.UtilApi;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailViewModel extends ViewModel {

    private MutableLiveData<Boolean> isLoading;
    Activity activity;

    private MutableLiveData<List<Movie>> movieList;
    private List<Movie> moviedetail;
    String newsId;

    public MovieDetailViewModel(Activity activity, String newsId) {
        isLoading = new MutableLiveData<>();
        movieList = new MutableLiveData<>();
        moviedetail = new ArrayList<>();
        this.newsId = newsId;

        if (ActivityUtils.checkInternetConnection(activity)) {
            loadDataFromServive();
        } else {

            Toast.makeText(activity, R.string.network_connection, Toast.LENGTH_SHORT).show();

        }
    }

    public MutableLiveData<List<Movie>> getMovieDetail() {
        return movieList;
    }

    private void setMovieList(List<Movie> movie) {
        movieList.postValue(movie);
    }


    public MutableLiveData<Boolean> getLoadingStatus() {
        return isLoading;
    }

    private void setIsLoading(boolean loading) {
        isLoading.postValue(loading);
    }

    public void loadDataFromServive() {
        setIsLoading(true);
        getMovieDetailFromServive(newsId);


    }


    public void getMovieDetailFromServive(String newsId) {
        UtilApi.getAPIService().getMovieById(Integer.valueOf(newsId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Movie>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Movie movie) {
                setIsLoading(false);
                movie.setTypeName(AppConstants.VİEW_TYPE_NAME.GET_MOVİE);
                movie.setTypeValue(1);
                moviedetail.add(movie);
                setMovieList(moviedetail);


            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, R.string.network_connection, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });

    }

}
