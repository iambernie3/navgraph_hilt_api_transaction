package com.gte.countryrestapplication.data.datasource.remote;

import com.gte.countryrestapplication.core.ApiResult;
import com.gte.countryrestapplication.data.datasource.remote.models.CountryDto;
import java.util.ArrayList;



public interface IRemoteDataSource {
    public ApiResult<ArrayList<CountryDto>> fetchCountry();
}

