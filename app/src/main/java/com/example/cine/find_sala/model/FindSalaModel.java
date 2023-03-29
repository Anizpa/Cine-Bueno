package com.example.cine.find_sala.model;

import com.example.cine.entities.SalaFicha;
import com.example.cine.find_sala.FindSalaContract;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindSalaModel implements FindSalaContract.Model {

    private Gson gson = new Gson();
    private int idSala;

    @Override
    public void findSalaWS(int idSala, OnFindSalaListener onFindSalaListener) {
        this.idSala = idSala;
        getSalaFicha(onFindSalaListener);
    }

    private void getSalaFicha(OnFindSalaListener onFindSalaListener) {
        Api apiPeliculas = peliculasApi.getPeliculasApi()
                .create(Api.class);
        Call<SalaFicha> salaFichaCall = apiPeliculas.getSalaFicha(idSala);
        salaFichaCall.enqueue(new Callback<SalaFicha>() {
            @Override
            public void onResponse(Call<SalaFicha> call, Response<SalaFicha> response) {
                SalaFicha salaFicha = response.body();
                onFindSalaListener.onSuccess(salaFicha);
            }

            @Override
            public void onFailure(Call<SalaFicha> call, Throwable t) {
                onFindSalaListener.onFailure("Error en la peticion " + t);
            }
        });
    }
}
