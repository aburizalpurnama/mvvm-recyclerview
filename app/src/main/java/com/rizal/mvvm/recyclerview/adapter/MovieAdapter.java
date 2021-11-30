package com.rizal.mvvm.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizal.mvvm.recyclerview.databinding.ItemMovieBinding;
import com.rizal.mvvm.recyclerview.listener.OnCLickMovieListener;
import com.rizal.mvvm.recyclerview.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movieList;
    private OnCLickMovieListener onCLickMovieListener;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public MovieAdapter(OnCLickMovieListener onCLickMovieListener) {
        this.onCLickMovieListener = onCLickMovieListener;
    }

    public MovieAdapter(List<Movie> movieList, OnCLickMovieListener onCLickMovieListener) {
        this.movieList = movieList;
        this.onCLickMovieListener = onCLickMovieListener;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding binding = ItemMovieBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie, onCLickMovieListener);
    }

    @Override
    public int getItemCount() {
        if (movieList != null){
            return movieList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding binding;

        public ViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie, OnCLickMovieListener cLickMovieListener){
            binding.setMovie(movie);
            binding.setOnClickMovieListner(cLickMovieListener);
            binding.executePendingBindings();
        }
    }
}
