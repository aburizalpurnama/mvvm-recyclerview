package com.rizal.mvvm.recyclerview.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rizal.mvvm.recyclerview.model.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> liveDataOfListMovie = new MutableLiveData<>();
    private MutableLiveData<Movie> liveDataMovie = new MutableLiveData<>();

    public MovieViewModel(List<Movie> listMovie) {
        liveDataOfListMovie.setValue(listMovie);
    }

    public LiveData<List<Movie>> getLiveDataOfListMovie() {
        return liveDataOfListMovie;
    }

    public void onMovieClicked(Movie movie){
        this.liveDataMovie.setValue(movie);
    }

    public LiveData<Movie> getLiveDataMovie(){
        return this.liveDataMovie;
    }

    public void addMovie(){
        List<Movie> listMovie = liveDataOfListMovie.getValue();
        assert listMovie != null;
        Movie movie = new Movie("New Movie", "This is the description and sinopsis of the movie", false);
        listMovie.add(movie);
        this.liveDataOfListMovie.setValue(listMovie);
    }
}
