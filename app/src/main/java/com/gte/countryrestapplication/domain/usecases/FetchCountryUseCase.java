package com.gte.countryrestapplication.domain.usecases;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;
import com.gte.countryrestapplication.domain.repositories.ICountryRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class FetchCountryUseCase {
    private final ICountryRepository repository;
    @Inject FetchCountryUseCase(ICountryRepository repository) {
        this.repository = repository;
    }

    public ApiResult<ArrayList<CountryDto>> fetchCountry() {
        return repository.fetchCountry();
    }
}
