package com.nalan.movieapp.ui.viewholder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.nalan.movieapp.R;
import com.nalan.movieapp.ui.adapter.MovieHorizontalListAdapter;
import com.nalan.movieapp.ui.adapter.MovieListVerticalAdapter;
import com.nalan.movieapp.util.ActivityUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieGridViewHolder extends  RecyclerView.ViewHolder {
    @BindView(R.id.rec_list_grid)RecyclerView recyclerView;
    @BindView(R.id.tv_title_list)
    TextView textView;
    public MovieGridViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setAdapter(MovieListVerticalAdapter adapter, Activity activity){
        ActivityUtils.setRecyclerGridLayoutManager(recyclerView,activity);
        recyclerView.setAdapter(adapter);

    }
    public void setTitle(String text){
        textView.setText(text);

    }
}
