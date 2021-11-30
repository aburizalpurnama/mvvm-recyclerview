package com.rizal.mvvm.recyclerview.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rizal.mvvm.recyclerview.model.Movie;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<Movie> movieLiveData =  new MutableLiveData<>();

    public DetailViewModel(Movie movie) {
        this.movieLiveData.setValue(movie);
    }

    public LiveData<Movie> getMovie (){
        return this.movieLiveData;
    }
}
