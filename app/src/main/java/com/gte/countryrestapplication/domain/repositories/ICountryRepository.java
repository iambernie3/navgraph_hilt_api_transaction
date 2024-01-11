package com.gte.countryrestapplication.domain.repositories;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public interface ICountryRepository {
    ApiResult<ArrayList<CountryDto>> fetchCountry();
}
