package com.gte.countryrestapplication.di;

import com.gte.countryrestapplication.data.datasource.remote.IRemoteDataSource;
import com.gte.countryrestapplication.data.datasource.remote.RemoteDataSourceImpl;
import com.gte.countryrestapplication.data.repository.CountryRepositoryImpl;
import com.gte.countryrestapplication.domain.repositories.ICountryRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract ICountryRepository bindCountryRepository(CountryRepositoryImpl repository);
    @Binds
    @Singleton
    abstract IRemoteDataSource bindRemoteDataSource(RemoteDataSourceImpl remoteDataSource);
}
