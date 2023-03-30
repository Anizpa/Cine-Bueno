package com.example.cine.find_peliculas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.cine.R;
import com.example.cine.entities.PeliculaFicha;
import com.example.cine.entities.Sala;
import com.example.cine.find_peliculas.FindPeliculasContract;
import com.example.cine.find_peliculas.presenter.FindPeliculasPresenter;
import com.example.cine.utils.Api;
import com.example.cine.utils.peliculasApi;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindPeliculasActivity extends AppCompatActivity implements FindPeliculasContract.View {

    private FindPeliculasPresenter findPeliculasPresenter;
    private FindPeliculasAdapter findPeliculasAdapter;
    private RecyclerView recyclerView;
    //private VideoView trailer;
    private TextView titulo, sinopsis, categoria, edad;
    private ImageView fotoTrailer;
    private RatingBar valoracion;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_peliculas);

        initComponents();
        initPresenter();
        initData();

        valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                puntuarPeliculaWS(v, id);
            }
        });
    }

    private void initComponents() {
        findPeliculasAdapter = new FindPeliculasAdapter(this);
        recyclerView = findViewById(R.id.listaSalas);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setAdapter(findPeliculasAdapter);

        //trailer = (VideoView) findViewById(R.id.trailer);
        titulo = findViewById(R.id.titulo);
        sinopsis = findViewById(R.id.sinopsis);
        categoria = findViewById(R.id.categoria);
        edad = findViewById(R.id.numEdad);
        fotoTrailer = findViewById(R.id.fotoTrailer);
        valoracion = findViewById(R.id.valoracion);

    }

    private void initPresenter() {
        findPeliculasPresenter = new FindPeliculasPresenter(this);
    }

    private void initData() {
        findPeliculasPresenter.findPeliculas(getIntent().getExtras().getInt("id"));
    }
    public String generateUrl(String s) {
        String[] p = s.split("/");
        String link = "https://drive.google.com/uc?export=download&id=" + p[5];
        return link;
    }
    @Override
    public void successFindPeliculas(PeliculaFicha fichaPelicula) {

        /*Uri uri = Uri.parse(fichaPelicula.getTrailer());
        trailer.setMediaController((new MediaController(this)));
        trailer.setVideoURI(uri);
        trailer.requestFocus();
        trailer.start();*/

        titulo.setText(fichaPelicula.getTitulo());
        sinopsis.setText(fichaPelicula.getSinopsis());
        categoria.setText(fichaPelicula.getCategoria());
        edad.setText(Integer.toString(fichaPelicula.getEdadRecomendada()));

        findPeliculasAdapter.addSalas(fichaPelicula.getSalas());

        id = fichaPelicula.getIdPelicula();
        String ulrImage = generateUrl(fichaPelicula.getImagen());
        Picasso.get().load(ulrImage).into(this.fotoTrailer);
    }

    @Override
    public void failureFindPeliculas(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

    private void puntuarPeliculaWS(float rating, int idPelicula){
        Api apiPeliculas = peliculasApi.getPeliculasApi().create(Api.class);
        Call<String> puntuarPeliculCall = apiPeliculas.ratePelicula(rating, idPelicula);
        puntuarPeliculCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "Pelicula puntuada", Toast.LENGTH_SHORT).show();
                valoracion.setEnabled(false);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anormalidad detectada, y no ha sido en la app", Toast.LENGTH_SHORT).show();
            }
        });
    }

}