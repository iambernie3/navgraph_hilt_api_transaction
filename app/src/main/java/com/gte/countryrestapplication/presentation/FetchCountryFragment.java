package com.gte.countryrestapplication.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gte.countryrestapplication.R;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;
import com.gte.countryrestapplication.databinding.FragmentFetchCountryBinding;

import java.util.ArrayList;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FetchCountryFragment extends Fragment {

    private FragmentFetchCountryBinding binding;
    private CountryViewModel countryViewModel;
    private ArrayList<CountryDto> countries = new ArrayList<>();

    public FetchCountryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fetch_country, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentFetchCountryBinding.bind(view);

        //FETCH COUNTRY IN BACKGROUND
        new Thread(new FetchCountryThread(countryViewModel)).start();
        apiObserver();
        gotoCountryInfo();
    }

    private void apiObserver() {
        countryViewModel.getApiState().observe(getViewLifecycleOwner(),result -> {
            switch (result.getApiStatus()) {
                case ON_PROGRESS:
                    binding.progress.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    binding.progress.setVisibility(View.GONE);
                    countries = result.getData();
                    break;
                case ERROR:
                    binding.progress.setVisibility(View.GONE);
                    break;
                default:
            }
        });
    }

    private void gotoCountryInfo() {
        binding.btnGoToInfo.setOnClickListener(v -> {
            NavDirections action = FetchCountryFragmentDirections.
                    actionFetchCountryFragmentToFragmentCountryInfo(
                            countries.get(2).getName().getCommon(),
                            countries.get(2).getRegion(),
                            countries.get(2).getCapital().get(0)
                    );
            Navigation.findNavController(v).navigate(action);
        });
    }
}