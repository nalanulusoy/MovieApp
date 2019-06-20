package com.nalan.movieapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nalan.movieapp.R;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.model.MovieResult;
import com.nalan.movieapp.ui.viewholder.MovieItemViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieHorizontalListAdapter extends RecyclerView.Adapter<MovieItemViewHolder> {

    List<Movie> mItems;
    Activity activity;

    public MovieHorizontalListAdapter(List<Movie> mItems, Activity activity) {
        this.mItems = mItems;
        this.activity=activity;
    }

    @NonNull
    @Override
    public MovieItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_moview_item,
                parent, false);
        return new MovieItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemViewHolder holder, int position) {
        Movie movie=mItems.get(position);


        if(movie.voteAverage!=null){
            holder.setPoint(Double.toString(movie.voteAverage));
        }
        if(movie.posterUrl!=null){

            holder.setImageView(AppConstants.IMAGE_PATH+movie.posterUrl,activity);
        }
        if(movie.originalTitle!=null){
            holder.setTitle(movie.originalTitle);
        }

    }

    @Override
    public int getItemCount() {
        if (mItems!=null && mItems.size() > 0) {
            return mItems.size();
        } else {
            return 0;
        }

    }
}
