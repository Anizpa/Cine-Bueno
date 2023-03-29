package com.example.cine.find_peliculas.model;

import com.example.cine.entities.PeliculaFicha;
import com.example.cine.find_peliculas.FindPeliculasContract;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindPeliculasModel implements FindPeliculasContract.Model {

    private Gson gson = new Gson();
    private int idPelicula;

    @Override
    public void findPeliculasWS(int idPelicula, OnFindPeliculasListener onFindPeliculasListener) {
        this.idPelicula = idPelicula;
        getPeliculaFicha(onFindPeliculasListener);
    }

    private void getPeliculaFicha(final OnFindPeliculasListener onFindPeliculasListener) {
        Api apiPeliculas = peliculasApi.getPeliculasApi().create(Api.class);

        Call<PeliculaFicha> peliculasFichaCall = apiPeliculas
                .getPeliculaFicha(idPelicula);
        peliculasFichaCall.enqueue(new Callback<PeliculaFicha>() {
            @Override
            public void onResponse(Call<PeliculaFicha> call, Response<PeliculaFicha> response) {
                PeliculaFicha fichaPelicula = response.body();
                onFindPeliculasListener.onSuccess(fichaPelicula);
            }

            @Override
            public void onFailure(Call<PeliculaFicha> call, Throwable t) {
                onFindPeliculasListener.onFailure("Error al realizar la petición -> " + t);
            }
        });
    }
}
