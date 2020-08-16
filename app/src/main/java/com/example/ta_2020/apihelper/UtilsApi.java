package com.example.ta_2020.apihelper;

public class UtilsApi {
    public static final String BASE_URL = "https://darkyasha.goes2nobel.com/TA/back-end/api/";

    public static ApiInterface getApiService(){
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }

}
