package com.rizal.mvvm.recyclerview.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rizal.mvvm.recyclerview.model.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> liveDataOfListMovie = new MutableLiveData<>();
    private List<Movie> listMovie = null;

    public MovieViewModel(List<Movie> listMovie) {
        this.listMovie = listMovie;
        liveDataOfListMovie.setValue(listMovie);
    }

    public LiveData<List<Movie>> getLiveDataOfListMovie() {
        return liveDataOfListMovie;
    }

    public void addMovie(){
        Movie movie = new Movie("New Movie", "This is the description and sinopsis of the movie", false);
        this.listMovie.add(movie);
        this.liveDataOfListMovie.setValue(listMovie);
    }
}
