package com.rizal.mvvm.recyclerview.vmFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.rizal.mvvm.recyclerview.model.Movie;
import com.rizal.mvvm.recyclerview.ui.detail.DetailViewModel;

public class DetailViewModelFactory implements ViewModelProvider.Factory {
    private Movie movie;

    public DetailViewModelFactory(Movie movie) {
        this.movie = movie;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if (aClass.isAssignableFrom(DetailViewModel.class)){
            return (T) new DetailViewModel(movie);
        }else{
            throw new IllegalArgumentException("Wrong view model class");
        }
    }
}
