package com.rizal.mvvm.recyclerview.ui.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizal.mvvm.recyclerview.R;
import com.rizal.mvvm.recyclerview.adapter.MovieAdapter;
import com.rizal.mvvm.recyclerview.databinding.FragmentMovieBinding;
import com.rizal.mvvm.recyclerview.listener.OnCLickMovieListener;
import com.rizal.mvvm.recyclerview.model.Movie;
import com.rizal.mvvm.recyclerview.vmFactory.MovieViewModelFactory;

import java.util.ArrayList;
import java.util.List;


public class MovieFragment extends Fragment {

    FragmentMovieBinding binding;
    MovieViewModel viewModel;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        MovieViewModelFactory viewModelFactory = new MovieViewModelFactory(getMovies());
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MovieViewModel.class);

        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRvMovie();


    }

    private List<Movie> getMovies(){
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Naga Bonar", "Film Perjuangan Naga Bonar Melawan Penjajah Belanda", false));
        movieList.add(new Movie("Naga Bonar Jadi Dua", "Film Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng", false));
        movieList.add(new Movie("Naga Binal", "Film Perselingkuhan antara majikan dan tukang kebon", false));
        movieList.add(new Movie("Bau Naga", "Film wanita dengan mulut bau naga", false));
        return movieList;
    }

    private void setUpRvMovie() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        MovieAdapter adapter = new MovieAdapter(new OnCLickMovieListener() {
            @Override
            public void onMovieClicked(Movie movie) {
                viewModel.onMovieClicked(movie);
                NavDirections action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(movie);
                Navigation.findNavController(requireView()).navigate(action);
            }
        });
        RecyclerView recyclerView = binding.rvMovie;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getLiveDataOfListMovie().observe(getViewLifecycleOwner(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setMovieList(movies);
            }
        });

    }
}