package com.nalan.movieapp.ui.fragment;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.di.Injectable;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.ui.viewmodel.HomeMovieViewModel;
import com.nalan.movieapp.ui.viewmodel.HomeMovieViewModelFactory;
import com.nalan.movieapp.ui.viewmodel.MovieDetailViewModel;
import com.nalan.movieapp.ui.viewmodel.MovieDetailViewModelFactory;

import java.util.List;

import javax.inject.Inject;


public class MovieDetailFragment extends Fragment implements Injectable ,View.OnClickListener{

    private static final String ARG_MOVİE_ID = "movieId";
    private String movieId;
    View view;
    MovieDetailViewModelFactory factory;
    MovieDetailViewModel movieDetailViewModel;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.iv_movie_detail)
    ImageView imageView;
    @BindView(R.id.tv_summary)
    TextView tv_summary;
    @BindView(R.id.movie_name)
    TextView tv_name;
    @BindView(R.id.tv_overview)
    TextView tv_overview;
    @BindView(R.id.tv_date)
    TextView movie_date;
    @BindView(R.id.tv_vote)
    TextView tv_rate;

    @BindView(R.id.img_back)
    ImageButton imgback;
    @Inject
    NavigationController navigationController;


    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(String movieId) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MOVİE_ID, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieId = getArguments().getString(ARG_MOVİE_ID);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);
        movieDetailViewModel = createViewModel();
        imgback.setOnClickListener(this);
        movieDetailViewModel.getLoadingStatus().observe(this, new LoadingObserver());
        movieDetailViewModel.getMovieDetail().observe(this, new MovieDetailObserver());
        return view;
    }


    private MovieDetailViewModel createViewModel() {
        factory = new MovieDetailViewModelFactory(getActivity(), movieId);
        return ViewModelProviders.of(this, factory).get(MovieDetailViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if(v==imgback){
            navigationController.navigateToMovieDetailFragmentBack();

        }

    }


    private class MovieDetailObserver implements Observer<List<Movie>> {
        @Override
        public void onChanged(@Nullable List<Movie> movies) {
            if (movies == null) return;
            setInfoMovieDetail(movies);

        }
    }


    public void setImageView(String url, Activity activity){
        Glide.with(activity).load(url).asBitmap()
                .fitCenter().into(imageView);
    }

    public void setInfoMovieDetail(List<Movie> movieDetail) {

        for (int i = 0; i < movieDetail.size(); i++) {

            if (movieDetail.get(i).originalTitle != null) {
                tv_name.setText(movieDetail.get(i).originalTitle);
            }
            if (movieDetail.get(i).posterUrl != null) {
                setImageView(AppConstants.IMAGE_PATH_ORİGİNAL+movieDetail.get(i).posterUrl,getActivity());
            }
            if (movieDetail.get(i).overview != null) {
                tv_summary.setText(movieDetail.get(i).overview);
            }
            if (movieDetail.get(i).releaseYear != null) {
                movie_date.setText(movieDetail.get(i).releaseYear);
            }

            if (movieDetail.get(i).voteAverage != null) {
                tv_rate.setText(Double.valueOf(movieDetail.get(i).voteAverage).toString());
            }

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
