package com.gte.countryrestapplication.presentation;

public class FetchCountryThread implements Runnable {
    private final CountryViewModel countryViewModel;

    public FetchCountryThread(CountryViewModel countryViewModel) {
        this.countryViewModel = countryViewModel;
    }

    @Override
    public void run() {
        countryViewModel.fetchCountries();
    }
}
