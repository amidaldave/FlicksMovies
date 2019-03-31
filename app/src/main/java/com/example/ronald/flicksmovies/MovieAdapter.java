package com.example.ronald.flicksmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ronald.flicksmovies.models.Config;
import com.example.ronald.flicksmovies.models.Movie;

import java.util.ArrayList;

/**
 * Created by Ronald on 3/24/2019.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    ArrayList<Movie> movies;
    Config config;
    Context context;
    public MovieAdapter(ArrayList<Movie> movies) {

        this.movies = movies;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View movieView =inflater.inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());

        String imageUrl=config.getImageUrl(config.getPosterSize(),movie.getPosterPath());

        Glide.with(context)
                .load(imageUrl)
                .into(holder.ivPosterImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPosterImage;
        TextView tvTitle;
        TextView tvOverview;
        public ViewHolder(View itemView) {
            super(itemView);
            ivPosterImage=(ImageView) itemView.findViewById(R.id.ivPosterImage);
            tvOverview=(TextView)itemView.findViewById(R.id.tvOverview);
            tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
        }
    }
}
