package com.nalan.movieapp.ui.viewholder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nalan.movieapp.R;
import com.nalan.movieapp.common.NavigationController;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_item)
    ImageView imageView;
    @BindView(R.id.tv_point_horizontal)
    TextView textView;
    @BindView(R.id.tv_movie)TextView tv_title;

    public MovieItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void setImageView(String url, Activity activity){
        Glide.with(activity).load(url).asBitmap()
                .fitCenter().into(imageView);
    }
    public  void setTitle(String title){
        tv_title.setText(title);
    }
    public void setPoint(String point){
        textView.setText(point);
    }
    public void setClickListener (String newsId,NavigationController navigationController){

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navigationController.navigateToMovieDetailFragment(newsId);

            }
        });

    }


}
