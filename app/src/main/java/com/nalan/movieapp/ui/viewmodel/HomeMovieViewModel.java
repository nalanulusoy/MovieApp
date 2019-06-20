package com.nalan.movieapp.ui.viewmodel;

import android.app.Activity;
import android.widget.Toast;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.MovieResult;
import com.nalan.movieapp.util.ActivityUtils;
import com.nalan.movieapp.util.UtilApi;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

public class HomeMovieViewModel extends ViewModel {
    private MutableLiveData<Boolean> isLoading;
    Activity activity;

    private MutableLiveData<List<Object>> movieList;
    public HomeMovieViewModel(Activity activity) {
        this.activity=activity;
        isLoading = new MutableLiveData<>();
        movieList=new MutableLiveData<>();


        if(ActivityUtils.checkInternetConnection(activity)){
            loadDataFromServive();
        }
        else{

            Toast.makeText(activity, R.string.network_connection, Toast.LENGTH_SHORT).show();

        }


    }

    public MutableLiveData<Boolean> getLoadingStatus() {
        return isLoading;
    }

    public MutableLiveData<List<Object>>getMovieList() {
        return movieList;
    }


    private void setMovieList(List<Object>movie){
        movieList.postValue(movie);
    }

    private void setIsLoading(boolean loading) {
        isLoading.postValue(loading);
    }

    public void fetchMovieService(){

        Observable<List<Object>> result =
                Observable.zip(UtilApi.getAPIService().getPlayingMovies().subscribeOn(Schedulers.io()), UtilApi.getAPIService().getPopularMovies().subscribeOn(Schedulers
                        .io()), UtilApi.getAPIService().getRatedMovie().subscribeOn(Schedulers.io()), new Function3<MovieResult, MovieResult, MovieResult, List<Object>>() {
                    @Override
                    public List<Object> apply(MovieResult type1, MovieResult type2, MovieResult type3) {
                        setIsLoading(false);
                        List<Object> list = new ArrayList();
                        type1.setTypeValue(1);
                        type1.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_lATEST_MOVİE);
                        list.add(type1);
                        type2.setTypeValue(2);
                        type2.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_POPULAR_MOVİE);
                        list.add(type2);
                        type3.setTypeValue(3);
                        type3.setTypeName(AppConstants.VİEW_TYPE_NAME.TOP_RATED_MOVİE);
                        list.add(type3);
                        return list;
                    }
                });

        result.subscribe(new Observer<List<Object>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Object> objects) {

                  setMovieList(objects);

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



    public void loadDataFromServive(){
        setIsLoading(true);
        fetchMovieService();

    }
}
