package com.example.cine.list_all_cine_films;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cine.R;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_peliculas.view.ListPeliculasAdapter;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAllCineActivity extends AppCompatActivity {
    private ListPeliculasAdapter listPeliculasAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_cine);

        initComponents();
        initData();
    }

    private void initComponents() {
        listPeliculasAdapter = new ListPeliculasAdapter(this);
        recyclerView = findViewById(R.id.listaAllPeliculasRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(listPeliculasAdapter);
    }

    private void initData() {
        int idCine = getIntent().getExtras().getInt("idCine");
        getPeliculasWS(idCine);
    }

    private void getPeliculasWS(int idCine) {
        Api apiPeliculas = peliculasApi.getPeliculasApi().create(Api.class);
        Call<List<Peliculas>> peliculasRespuestaCall = apiPeliculas.getPeliculasCine(idCine);
        peliculasRespuestaCall.enqueue(new Callback<List<Peliculas>>() {
            @Override
            public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                List<Peliculas> peliculas = response.body();
                if (peliculas.size() != 0) {
                    listPeliculasAdapter.addPeliculas(peliculas);
                }
            }

            @Override
            public void onFailure(Call<List<Peliculas>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al pedir datos" ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}