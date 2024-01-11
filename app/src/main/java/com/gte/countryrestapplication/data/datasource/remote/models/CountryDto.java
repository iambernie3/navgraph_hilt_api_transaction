package com.gte.countryrestapplication.data.datasource.remote.models;

import java.util.List;

public class CountryDto {
    private final CommonName name;
    private final List<String> capital;
    private final String region;

    public CountryDto(CommonName name, List<String> capital, String region) {
        this.name = name;
        this.capital = capital;
        this.region = region;
    }

    public CommonName getName() {
        return name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }
}
