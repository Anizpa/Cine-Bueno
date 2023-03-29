package com.example.cine.list_cines.model;


import com.example.cine.entities.Cines;
import com.example.cine.list_cines.ListCinesContract;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCinesModel implements ListCinesContract.Model{
    private Gson gson = new Gson();

    @Override
    public void listCinesWS(ListCinesContract.Model.OnLstCinesListener onListCinesListener) {

        getCinesService(onListCinesListener);
    }
    private void getCinesService(final ListCinesContract.Model.OnLstCinesListener onListCinesListener) {
        Api apiPeliculas = peliculasApi.getPeliculasApi().create(Api.class);

        Call<List<Cines>> cinesRespuestaCall = apiPeliculas.getCinesList();
        cinesRespuestaCall.enqueue(new Callback<List<Cines>>() {
            @Override
            public void onResponse(Call<List<Cines>> call,
                                   Response<List<Cines>> response) {
                //PeliculasRespuesta peliculasRespuesta = response.body();
                List<Cines> peliculasList = response.body();
                onListCinesListener.onSuccess(peliculasList);
            }

            @Override
            public void onFailure(Call<List<Cines>> call, Throwable t) {
                onListCinesListener.onFailure("Error en la peticion " + t);
            }
        });
    }
}
