package com.gte.countryrestapplication.data.datasource.remote;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.core.ApiStatus;
import com.gte.countryrestapplication.core.CountryApi;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class RemoteDataSourceImpl implements IRemoteDataSource {
    private final CountryApi api;
    @Inject
    public RemoteDataSourceImpl(CountryApi api) {
        this.api = api;
    }
    @Override
    public ApiResult<ArrayList<CountryDto>> fetchCountry() {
        ApiResult<ArrayList<CountryDto>> apiResult;
        Call<ArrayList<CountryDto>> apiCall = api.fetchCountries();
        try {
            Response<ArrayList<CountryDto>> response = apiCall.execute();
            if(response.code() == 200) {
                apiResult = new ApiResult<>(response.body(), ApiStatus.SUCCESS,response.message());
            }else{
                apiResult = new ApiResult<>(response.body(), ApiStatus.ERROR,response.message());
            }
            return apiResult;
        } catch (IOException e) {
            apiResult = new ApiResult<>(null, ApiStatus.ERROR,e.getMessage());
            return apiResult;
        }


//        apiCall.enqueue(new Callback<ArrayList<CountryDto>>() {
//            @Override
//            public void onResponse(@NonNull Call<ArrayList<CountryDto>> call, @NonNull Response<ArrayList<CountryDto>> response) {
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ArrayList<CountryDto>> call, @NonNull Throwable t) {
//
//            }
//        });
    }
}
