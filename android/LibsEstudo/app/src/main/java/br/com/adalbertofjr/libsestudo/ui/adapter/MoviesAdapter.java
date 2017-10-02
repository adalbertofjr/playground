package br.com.adalbertofjr.libsestudo.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.adalbertofjr.libsestudo.R;
import br.com.adalbertofjr.libsestudo.databinding.MovieItemBinding;
import br.com.adalbertofjr.libsestudo.model.Movie;

/**
 * LibsEstudo
 * MoviesAdapter
 * <p>
 * Created by Adalberto Fernandes Júnior on 26/12/2016.
 * Copyright © 2016 - Adalberto Fernandes Júnior. All rights reserved.
 */


public class MoviesAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Movie> mMovies;

    public MoviesAdapter(Context mContext, List<Movie> mMovies) {
        this.mMovies = mMovies;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = mMovies.get(position);

        MovieItemBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.movie_item, parent, false);
        } else {
            binding = DataBindingUtil.bind(convertView);
        }
        binding.setMovie(movie);

        return binding.getRoot();
    }
}
