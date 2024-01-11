package com.gte.countryrestapplication.core;

import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApi {
    @GET("/v3.1/all")
    Call<ArrayList<CountryDto>> fetchCountries();
}
