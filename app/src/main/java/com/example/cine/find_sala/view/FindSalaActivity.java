package com.example.cine.find_sala.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cine.R;
import com.example.cine.entities.Sala;
import com.example.cine.entities.SalaFicha;
import com.example.cine.find_sala.FindSalaContract;
import com.example.cine.find_sala.presenter.FindSalaPresenter;

public class FindSalaActivity extends AppCompatActivity implements FindSalaContract.View {

    private FindSalaPresenter findSalaPresenter;
    private TextView titulo, cine, sala, horario, butacasLibres, numeroEntradas;
    private ImageButton mas, menos;
    private int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_sala);

        initComponents();
        initPresenter();
        initData();

        mas.setOnClickListener(view -> {
            cantidad++;
            numeroEntradas.setText(Integer.toString(cantidad));
        });
        menos.setOnClickListener(view -> {
            if(cantidad > 0){
                cantidad--;
            }
            if(cantidad == 0){
                numeroEntradas.setText("");
            }else{
                numeroEntradas.setText(Integer.toString(cantidad));
            }
        });
    }

    private void initComponents() {
        titulo = findViewById(R.id.tituloCompra);
        cine = findViewById(R.id.cineCompra);
        sala = findViewById(R.id.salaCompra);
        horario = findViewById(R.id.horarioCompra);
        butacasLibres = findViewById(R.id.butacasCompra);
        mas = findViewById(R.id.mas);
        menos = findViewById(R.id.menos);
        numeroEntradas = findViewById(R.id.numeroEntradas);

    }

    private void initPresenter() {
        findSalaPresenter = new FindSalaPresenter(this);
    }

    private void initData() {
        findSalaPresenter.findSala(getIntent().getExtras().getInt("idSala"));
    }

    @Override
    public void successFindSala(Sala salas) {
        titulo.setText(salas.getTitulo());
        cine.setText(salas.getNombreCine());
        sala.setText(Integer.toString(salas.getIdSala()));
        horario.setText(salas.getHorario());
        butacasLibres.setText(Integer.toString(salas.getButacas()));
    }

    @Override
    public void failureFindSala(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}