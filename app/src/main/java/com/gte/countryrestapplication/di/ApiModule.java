package com.gte.countryrestapplication.di;

import com.gte.countryrestapplication.core.CountryApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Provides
    @Singleton
    CountryApi provideCountryApi() {
        return new Retrofit.Builder()
                .baseUrl("https://restcountries.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryApi.class);
    }
}
