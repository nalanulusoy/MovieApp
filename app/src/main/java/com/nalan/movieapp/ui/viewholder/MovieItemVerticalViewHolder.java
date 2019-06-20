package com.nalan.movieapp.ui.viewholder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nalan.movieapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieItemVerticalViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.img_item_vertical)
    ImageView imageView;

    @BindView(R.id.tv_movie)TextView tv_title;
    public MovieItemVerticalViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setImageView(String url, Activity activity){
        Glide.with(activity).load(url).into(imageView);
    }
    public  void setTitle(String title){
        tv_title.setText(title);
    }
}
