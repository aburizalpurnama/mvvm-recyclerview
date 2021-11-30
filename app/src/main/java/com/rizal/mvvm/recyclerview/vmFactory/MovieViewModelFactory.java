package com.rizal.mvvm.recyclerview.vmFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.rizal.mvvm.recyclerview.model.Movie;
import com.rizal.mvvm.recyclerview.ui.movie.MovieViewModel;

import java.util.List;

public class MovieViewModelFactory implements ViewModelProvider.Factory {

    private List<Movie> listMovie;

    public MovieViewModelFactory(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if (aClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(listMovie);
        }
        throw new IllegalArgumentException("View model yang diminta tidak sesuai (MainActivityViewModel");
    }
}
