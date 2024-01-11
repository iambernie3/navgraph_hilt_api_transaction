package com.gte.countryrestapplication.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.core.ApiStatus;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;
import com.gte.countryrestapplication.domain.usecases.FetchCountryUseCase;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class CountryViewModel extends ViewModel {
     @Inject FetchCountryUseCase fetchCountryUseCase;

    private final MutableLiveData<ApiResult<ArrayList<CountryDto>>> countryApiState = new MutableLiveData<>();

    public LiveData<ApiResult<ArrayList<CountryDto>>> getApiState() {
        return countryApiState;
    }

    @Inject
    public CountryViewModel(FetchCountryUseCase fetchCountryUseCase) {
        this.fetchCountryUseCase = fetchCountryUseCase;
    }

    public void fetchCountries() {
        countryApiState.postValue(new ApiResult<>(null, ApiStatus.ON_PROGRESS,""));
        ApiResult<ArrayList<CountryDto>> result = fetchCountryUseCase.fetchCountry();
        countryApiState.postValue(result);
    }

}
