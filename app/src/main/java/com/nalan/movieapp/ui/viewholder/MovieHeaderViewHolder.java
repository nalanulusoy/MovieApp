package com.nalan.movieapp.ui.viewholder;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nalan.movieapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieHeaderViewHolder extends RecyclerView.ViewHolder{
@BindView(R.id.img_header)
    ImageView imageView;
    public MovieHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void setImageView(String url, Activity activity){
        Glide.with(activity).load(url).asBitmap()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);

    }
}
