package com.example.cine.utils;


import com.example.cine.entities.Peliculas;
import com.example.cine.entities.PeliculasRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("Peliculas/FINDALL")
    Call<List<Peliculas>> getPeliculasList(
            @Query("titulo") String titulo,
            @Query("categoria") String categoria,
            @Query("edadRecomendada") int edadRecomendada,
            @Query("valoracion") double valoracion,
            @Query("limite") int limite,
            @Query("id") int id,
            @Query("imagen") String imagen
            );

}
