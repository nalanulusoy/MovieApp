package com.nalan.movieapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;
import com.nalan.movieapp.di.Injectable;
import com.nalan.movieapp.ui.adapter.MovieAdapter;
import com.nalan.movieapp.ui.viewmodel.HomeMovieViewModel;
import com.nalan.movieapp.ui.viewmodel.HomeMovieViewModelFactory;
import com.nalan.movieapp.util.ActivityUtils;

import java.util.List;

import javax.inject.Inject;


public class HomeMovieFragment extends Fragment implements Injectable {

    HomeMovieViewModel homeMovieViewModel;
    View view;
    MovieAdapter movieAdapter;

    @BindView(R.id.rec_movie_list)
    RecyclerView rec_movie_list;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @Inject
    NavigationController navigationController;

    HomeMovieViewModelFactory factory;
    public HomeMovieFragment() {
        // Required empty public constructor
    }


    public static HomeMovieFragment newInstance(String param1, String param2) {
        HomeMovieFragment fragment = new HomeMovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home_movie, container, false);
        ButterKnife.bind(this, view);
        homeMovieViewModel=createViewModel();
        homeMovieViewModel.getLoadingStatus().observe(this, new LoadingObserver());
        homeMovieViewModel.getMovieList().observe(this,new MovieObserver());
        setAdapter();
        return  view;
    }

    public void setAdapter(){
        ActivityUtils.setRecyclerVerticalLayoutManager(rec_movie_list,getActivity());
        movieAdapter=new MovieAdapter(getActivity(),navigationController);
        rec_movie_list.setAdapter(movieAdapter);
    }
    private HomeMovieViewModel createViewModel() {
        factory=new  HomeMovieViewModelFactory(getActivity());
        return ViewModelProviders.of(this, factory).get(HomeMovieViewModel.class);
    }

    private class MovieObserver implements Observer<List<Object>> {
        @Override
        public void onChanged(@Nullable List<Object> movies) {
            if (movies == null) return;
           movieAdapter.setItems(movies);
        }
    }

    private class LoadingObserver implements Observer<Boolean> {

        @Override
        public void onChanged(@Nullable Boolean isLoading) {
            if (isLoading == null) return;
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}
