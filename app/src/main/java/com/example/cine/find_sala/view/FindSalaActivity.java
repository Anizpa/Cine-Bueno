package com.example.cine.find_sala.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cine.R;
import com.example.cine.entities.SalaFicha;
import com.example.cine.find_sala.FindSalaContract;
import com.example.cine.find_sala.presenter.FindSalaPresenter;

public class FindSalaActivity extends AppCompatActivity implements FindSalaContract.View {

    //En esta no hay recycler creo
    private FindSalaPresenter findSalaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_sala);

        initComponents();
        initPresenter();
        initData();
    }

    private void initComponents() {
        //Componentes visuales iniciar
    }

    private void initPresenter() {
        findSalaPresenter = new FindSalaPresenter(this);
    }

    private void initData() {
        findSalaPresenter.findSala(getIntent().getExtras().getInt(""));
    }

    @Override
    public void successFindSala(SalaFicha salaFicha) {
        // Poner datos con el getNombre etc...
    }

    @Override
    public void failureFindSala(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}