package com.example.cine.find_sala.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cine.R;
import com.example.cine.entities.Sala;
import com.example.cine.find_sala.FindSalaContract;
import com.example.cine.find_sala.presenter.FindSalaPresenter;
import com.example.cine.list_peliculas.view.ListPeliculasActivity;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindSalaActivity extends AppCompatActivity implements FindSalaContract.View {

    private FindSalaPresenter findSalaPresenter;
    private TextView titulo, cine, sala, horario, butacasLibres, numeroEntradas;
    private ImageButton mas, menos;
    private int cantidad;
    private static int notificacion = 2202;
    private Button btnComprar;
    private int idSala;
    private Sala salaCorreo;

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

        btnComprar.setOnClickListener(view -> {
            confirmarCompraWS();
        });
    }

    private void confirmarCompraWS(){
        Api peliApi = peliculasApi.getPeliculasApi().create(Api.class);
        Gson gson = new Gson();
        Call<String> entradaRespuestaCall = peliApi.addEntrada(idSala, cantidad, gson.toJson(salaCorreo));
        entradaRespuestaCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "¡Entradas compradas con éxito!", Toast.LENGTH_SHORT).show();
                showNotification();
                listPeliculas();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al procesar la compra", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void listPeliculas(){
        final Intent intent = new Intent(this, ListPeliculasActivity.class);
        startActivity(intent);
    }
    private void showNotification(){
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(androidx.constraintlayout.widget.R.drawable.notification_icon_background)
                .setContentTitle("Compra Realizada")
                .setContentText("Gracias por confiar en nuestra App (jaja)")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificacion, builder.build());
        notificacion++;
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones";
            String description = "Estandar";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("id", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
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
        btnComprar = findViewById(R.id.btnComprar);

    }

    private void initPresenter() {
        findSalaPresenter = new FindSalaPresenter(this);
    }

    private void initData() {
        findSalaPresenter.findSala(getIntent().getExtras().getInt("idSala"));
    }

    @Override
    public void successFindSala(Sala salas) {
        salaCorreo = salas;
        titulo.setText(salas.getTitulo());
        cine.setText(salas.getNombreCine());
        sala.setText(Integer.toString(salas.getIdSala()));
        horario.setText(salas.getHorario());
        idSala = salas.getIdSala();
        butacasLibres.setText(Integer.toString(salas.getButacas()));
    }

    @Override
    public void failureFindSala(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}