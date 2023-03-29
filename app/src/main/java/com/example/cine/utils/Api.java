package com.example.cine.utils;


import com.example.cine.entities.PeliculaFicha;
import com.example.cine.entities.Peliculas;
import com.example.cine.entities.PeliculasRespuesta;
import com.example.cine.entities.Sala;
import com.example.cine.entities.SalaFicha;

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

    //REVISAR DATOS ENCAJAN CON API
    @GET("Peliculas/GETFICHA")
    Call<PeliculaFicha> getPeliculaFicha(@Query("id") int idPelicula);

    @GET("Salas/GETFICHA")
    Call<Sala> getSalaFicha(@Query("id") int idSala);
}
