package com.nalan.movieapp.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;
import com.nalan.movieapp.constants.AppConstants;
import com.nalan.movieapp.model.Movie;
import com.nalan.movieapp.model.MovieResult;
import com.nalan.movieapp.ui.viewholder.MovieGridViewHolder;
import com.nalan.movieapp.ui.viewholder.MovieHeaderViewHolder;
import com.nalan.movieapp.ui.viewholder.MovieHorizontalViewHolder;
import com.nalan.movieapp.ui.viewholder.MovieVerticalViewHolder;
import com.nalan.movieapp.ui.viewholder.StandartViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> mItems;
    Activity activity;

   NavigationController  navigationController;
    public MovieAdapter(Activity activity, NavigationController navigationController) {
        this.activity = activity;
        this.navigationController=navigationController;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == AppConstants.VİEW_TYPE.HORİZONTAL_LİST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_horizontal_list,
                    parent, false);
            return new MovieHorizontalViewHolder(view);
        } else if (viewType == AppConstants.VİEW_TYPE.VERTİCAL_LİST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vertical_list,
                    parent, false);
            return new MovieVerticalViewHolder(view);

        } else if (viewType == AppConstants.VİEW_TYPE.GRİD_LİST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_list,
                    parent, false);
            return new MovieGridViewHolder(view);

        } else if (viewType == AppConstants.VİEW_TYPE.GET_MOVİE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header_view,
                    parent, false);
            return new MovieHeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_custom_view,
                    parent, false);
            return new StandartViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Object item = mItems.get(position);

        if (holder instanceof MovieHeaderViewHolder) {
            Movie movieResult = (Movie) item;
            MovieHeaderViewHolder viewHolder = (MovieHeaderViewHolder) holder;
            if (movieResult.posterUrl != null) {
                viewHolder.setImageView(AppConstants.IMAGE_PATH_ORİGİNAL + movieResult.posterUrl, activity);
            }

            if(Integer.valueOf(movieResult.id).toString()!=null){
                viewHolder.setClickListener(Integer.valueOf(movieResult.id).toString(),navigationController);
            }

        } else if (holder instanceof MovieHorizontalViewHolder) {
            MovieHorizontalViewHolder viewHolder = (MovieHorizontalViewHolder) holder;
            MovieResult movieResult = (MovieResult) item;
            viewHolder.setTitle(movieResult.getTypeName());
            MovieHorizontalListAdapter movieHorizontalListAdapter = new MovieHorizontalListAdapter(movieResult.getResults(), activity,navigationController);
            viewHolder.setAdapter(movieHorizontalListAdapter, activity);

        } else if (holder instanceof MovieGridViewHolder) {

            MovieGridViewHolder viewHolder = (MovieGridViewHolder) holder;
            MovieResult movieResult = (MovieResult) item;
            viewHolder.setTitle(movieResult.getTypeName());
            MovieListVerticalAdapter movieListAdapter = new MovieListVerticalAdapter(movieResult.getResults(), activity,navigationController);
            viewHolder.setAdapter(movieListAdapter, activity);



        } else if (holder instanceof MovieVerticalViewHolder) {

            MovieVerticalViewHolder viewHolder = (MovieVerticalViewHolder) holder;
            MovieResult movieResult = (MovieResult) item;
            viewHolder.setTitle(movieResult.getTypeName());
            MovieListVerticalAdapter movieListAdapter = new MovieListVerticalAdapter(movieResult.getResults(), activity,navigationController);
            viewHolder.setAdapter(movieListAdapter, activity);

        }


    }

    @Override
    public int getItemCount() {
        if (mItems != null && mItems.size() > 0) {
            return mItems.size();

        } else {
            return 0;
        }
    }


    public void setItems(List<Object> items) {
        mItems = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        Object item = mItems.get(position);

        if (item instanceof MovieResult) {

            MovieResult movieResult = (MovieResult) item;

            if (movieResult.getTypeName().equals(AppConstants.VİEW_TYPE_NAME.TOP_lATEST_MOVİE)) {
                viewType = AppConstants.VİEW_TYPE.GRİD_LİST;
                return viewType;
            } else if (movieResult.getTypeName().equals(AppConstants.VİEW_TYPE_NAME.TOP_RATED_MOVİE)) {
                viewType = AppConstants.VİEW_TYPE.VERTİCAL_LİST;
                return viewType;

            } else if (movieResult.getTypeName().equals(AppConstants.VİEW_TYPE_NAME.TOP_POPULAR_MOVİE)) {
                viewType = AppConstants.VİEW_TYPE.HORİZONTAL_LİST;
                return viewType;

            }

        }
        else if(item instanceof Movie){
            Movie movieResult = (Movie) item;
             if (movieResult.getTypeName().equals(AppConstants.VİEW_TYPE_NAME.GET_MOVİE)) {
                viewType = AppConstants.VİEW_TYPE.GET_MOVİE;
                return viewType;
            }
        }

        return viewType;
    }
}
