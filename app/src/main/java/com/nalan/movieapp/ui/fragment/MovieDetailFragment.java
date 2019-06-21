package com.nalan.movieapp.ui.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nalan.movieapp.R;


public class MovieDetailFragment extends Fragment {

    private static final String ARG_MOVİE_ID = "movieId";
    private String movieId;
    View view;



    public MovieDetailFragment() {
        // Required empty public constructor
    }

    public static MovieDetailFragment newInstance(String param1, String param2) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MOVİE_ID, param1);

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
      view= inflater.inflate(R.layout.fragment_movie_detail, container, false);
      ButterKnife.bind(this, view);

      return  view;
    }

}
