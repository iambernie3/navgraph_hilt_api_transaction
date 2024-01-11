package com.gte.countryrestapplication.data.repository;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.data.datasource.remote.IRemoteDataSource;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;
import com.gte.countryrestapplication.domain.repositories.ICountryRepository;
import java.util.ArrayList;

import javax.inject.Inject;


public class CountryRepositoryImpl implements ICountryRepository {
    private final IRemoteDataSource dataSource;

    @Inject public CountryRepositoryImpl(IRemoteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ApiResult<ArrayList<CountryDto>> fetchCountry() {
        return dataSource.fetchCountry();
    }
}
