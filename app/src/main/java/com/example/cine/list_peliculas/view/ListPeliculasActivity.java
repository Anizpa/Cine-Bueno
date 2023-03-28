package com.example.cine.list_peliculas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cine.R;
import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.entities.Peliculas;
import com.example.cine.list_peliculas.ListPeliculasContract;
import com.example.cine.list_peliculas.presenter.ListPeliculasPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListPeliculasActivity extends AppCompatActivity implements ListPeliculasContract.View, SearchView.OnQueryTextListener {

    private ListPeliculasPresenter listPeliculasPresenter;
    private ListPeliculasAdapter listPeliculasAdapter;
    private RecyclerView recyclerView;
    private ListPeliculasRequest listPeliculasRequest;
    private Button top10, drama, musical, accion;
    SearchView txtBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_peliculas);

        initComponents();
        initPresenter();
        initData();



        top10.setOnClickListener(view -> {
            listPeliculasRequest = new ListPeliculasRequest(null, null,
                    0, 0, 10, 0, null);
            listPeliculasPresenter.listPeliculas(listPeliculasRequest);
        });
        drama.setOnClickListener(view -> {
            listPeliculasRequest = new ListPeliculasRequest(null, "Drama",
                    0, 0, 100, 0, null);
            listPeliculasPresenter.listPeliculas(listPeliculasRequest);
        });
        musical.setOnClickListener(view -> {
            listPeliculasRequest = new ListPeliculasRequest(null, "Musical",
                    0, 0, 100, 0, null);
            listPeliculasPresenter.listPeliculas(listPeliculasRequest);
        });
        accion.setOnClickListener(view -> {
            listPeliculasRequest = new ListPeliculasRequest(null, "Accion",
                    0, 0, 100, 0, null);
            listPeliculasPresenter.listPeliculas(listPeliculasRequest);
        });

        txtBuscar.setOnQueryTextListener(this);


    }

    private void initComponents(){
        listPeliculasAdapter = new ListPeliculasAdapter(this);
        recyclerView = findViewById(R.id.listaPeliculas);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(listPeliculasAdapter);

        top10 = findViewById(R.id.top10);
        drama = findViewById(R.id.drama);
        musical = findViewById(R.id.musical);
        accion = findViewById(R.id.accion);
        txtBuscar = findViewById(R.id.searchView);

    }
    private void initPresenter(){
        listPeliculasPresenter = new ListPeliculasPresenter(this);
    }

    private void initData(){
        listPeliculasRequest = new ListPeliculasRequest(null, null, 0,
                0, 100, 0, null);
        listPeliculasPresenter.listPeliculas(listPeliculasRequest);
    }

    @Override
    public void successListPeliculas(List<Peliculas> listPeliculas) {
        listPeliculasAdapter.addPeliculas(listPeliculas);
    }

    @Override
    public void failureListPeliculas(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        listPeliculasAdapter.filtrado(s);
        return false;
    }
}