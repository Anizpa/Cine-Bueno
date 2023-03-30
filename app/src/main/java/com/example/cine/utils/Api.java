package com.example.cine.utils;


import com.example.cine.entities.Cines;
import com.example.cine.entities.PeliculaFicha;
import com.example.cine.entities.Peliculas;
import com.example.cine.entities.Sala;

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

    @GET("Peliculas/cine")
    Call<List<Peliculas>> getPeliculasCine(
                 @Query("idCine") int idCine
    );

    //REVISAR DATOS ENCAJAN CON API
    @GET("Peliculas/GETFICHA")
    Call<PeliculaFicha> getPeliculaFicha(@Query("id") int idPelicula);

    @GET("Salas/GETFICHA")
    Call<Sala> getSalaFicha(@Query("id") int idSala);

    @GET("Cines/GETFICHA")
    Call<List<Cines>> getCinesList();

    @GET("Entradas/add")
    Call<String> addEntrada(@Query("idSala") int idSala, @Query("cantidad") int cantidad, @Query("salaCorreo") String salaCorreoJSON);

    @GET("Peliculas/rate")
    Call<String> ratePelicula(@Query("valoracion") float valoracion,
                              @Query("idPelicula") int idPelicula);


}
