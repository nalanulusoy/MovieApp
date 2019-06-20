package com.nalan.movieapp.util;

import com.nalan.movieapp.connection.ApiClient;
import com.nalan.movieapp.connection.ApiService;

public class UtilApi {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";

    public static ApiClient getAPIService(){
        return ApiService.getClient(BASE_URL).create(ApiClient.class);
    }

}
