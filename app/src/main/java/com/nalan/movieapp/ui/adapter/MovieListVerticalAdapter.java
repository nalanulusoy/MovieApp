package com.nalan.movieapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.ui.viewholder.MovieItemVerticalViewHolder;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListVerticalAdapter  extends RecyclerView.Adapter<MovieItemVerticalViewHolder>  {
    List<Movie> mItems;
    Activity activity;
    NavigationController navigationController;

    public MovieListVerticalAdapter(List<Movie> mItems, Activity activity, NavigationController navigationController) {
        this.mItems = mItems;
        this.activity=activity;
        this.navigationController=navigationController;
    }

    @NonNull
    @Override
    public MovieItemVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vertical_item_list,
                parent, false);
        return new MovieItemVerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemVerticalViewHolder holder, int position) {
        Movie movie=mItems.get(position);

        if(movie.posterUrl!=null){

            holder.setImageView(AppConstants.IMAGE_PATH_ORİGİNAL+movie.posterUrl,activity);
        }
        if(movie.originalTitle!=null){
            holder.setTitle(movie.originalTitle);
        }
        if(Integer.valueOf(movie.id).toString()!=null){
            holder.setClickListener(Integer.valueOf(movie.id).toString(),navigationController);
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
