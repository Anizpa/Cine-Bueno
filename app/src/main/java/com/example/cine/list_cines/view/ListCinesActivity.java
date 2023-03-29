package com.example.cine.list_cines.view;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cine.R;
import com.example.cine.entities.Cines;
import com.example.cine.entities.ListPeliculasRequest;
import com.example.cine.list_cines.ListCinesContract;
import com.example.cine.list_cines.presenter.ListCinesPresenter;
import com.example.cine.list_peliculas.presenter.ListPeliculasPresenter;
import com.example.cine.list_peliculas.view.ListPeliculasAdapter;

import java.util.List;


public class ListCinesActivity extends AppCompatActivity implements ListCinesContract.View{

    private ListCinesPresenter listCinesPresenter;
    private ListCinesAdapter listCinesAdapter;
    private RecyclerView recyclerView;

    /*AÑADIR COMPONENTES QUE CREE PORQUE SOY LA MAS CHULA*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void initComponents(){
        listCinesAdapter = new ListCinesAdapter(this);
        recyclerView = findViewById(R.id.listaCines);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(listCinesAdapter);

        /*findViewById*/

    }
    private void initPresenter(){
        listCinesPresenter = new ListCinesPresenter(this);
    }

    private void initData(){
        listCinesPresenter.listCines();
    }




    @Override
    public void successListCines(List<Cines> listCines) {
        listCinesAdapter.addCines(listCines);
    }

    @Override
    public void failureListCines(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

}
