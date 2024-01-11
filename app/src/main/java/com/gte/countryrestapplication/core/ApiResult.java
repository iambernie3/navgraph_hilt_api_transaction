package com.gte.countryrestapplication.core;

public class ApiResult<T> {
    private final T data;
    private final ApiStatus apiStatus;
    private final String errorMessage;

    public ApiResult(T data, ApiStatus apiStatus,String errorMessage) {
        this.data = data;
        this.apiStatus = apiStatus;
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public ApiStatus getApiStatus() {
        return apiStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
