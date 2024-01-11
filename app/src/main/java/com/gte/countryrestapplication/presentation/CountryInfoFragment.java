package com.gte.countryrestapplication.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gte.countryrestapplication.R;
import com.gte.countryrestapplication.databinding.FragmentCountryInfoBinding;


public class CountryInfoFragment extends Fragment {

    private FragmentCountryInfoBinding binding;

    public CountryInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentCountryInfoBinding.bind(view);
        setData();
        exit();
    }

    private void setData() {
        CountryInfoFragmentArgs args = CountryInfoFragmentArgs.fromBundle(getArguments());
        binding.tvCountryName.setText(args.getCountryName());
        binding.tvCapitalName.setText(args.getCapitalName());
        binding.tvRegionName.setText(args.getRegionName());
    }

    private void exit() {
        binding.btnBackToHome.setOnClickListener(v -> {
            NavDirections action = CountryInfoFragmentDirections.actionFragmentCountryInfoToMainFragment();
            Navigation.findNavController(v).navigate(action);
        });
    }

}