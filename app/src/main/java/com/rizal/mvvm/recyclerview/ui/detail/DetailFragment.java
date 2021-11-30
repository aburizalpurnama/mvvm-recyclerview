package com.rizal.mvvm.recyclerview.ui.detail;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizal.mvvm.recyclerview.R;
import com.rizal.mvvm.recyclerview.databinding.FragmentDetailBinding;
import com.rizal.mvvm.recyclerview.model.Movie;
import com.rizal.mvvm.recyclerview.vmFactory.DetailViewModelFactory;


public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    DetailViewModel viewModel;

    public DetailFragment() {
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
        assert getArguments() != null;

        Movie movie = DetailFragmentArgs.fromBundle(getArguments()).getSelectedMovie();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false );
        DetailViewModelFactory detailViewModelFactory = new DetailViewModelFactory(movie);
        viewModel = new ViewModelProvider(this, detailViewModelFactory).get(DetailViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();

    }
}