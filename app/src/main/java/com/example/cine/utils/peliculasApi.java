package com.example.cine.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class peliculasApi {

    public static final String PELICULAS_API_URL=
            "http://192.168.104.54:8080/api-cine/webresources/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getPeliculasApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(PELICULAS_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
