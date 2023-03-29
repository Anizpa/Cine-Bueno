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
import com.squareup.picasso.Picasso;

public class FindPeliculasActivity extends AppCompatActivity implements FindPeliculasContract.View {

    private FindPeliculasPresenter findPeliculasPresenter;
    private FindPeliculasAdapter findPeliculasAdapter;
    private RecyclerView recyclerView;
    //private VideoView trailer;
    private TextView titulo, sinopsis, categoria, edad;
    private ImageView fotoTrailer;
    private RatingBar valoracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_peliculas);

        initComponents();
        initPresenter();
        initData();
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
        System.out.println(getIntent().getExtras().getInt("id"));
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


        String ulrImage = generateUrl(fichaPelicula.getImagen());
        Picasso.get().load(ulrImage).into(this.fotoTrailer);
    }

    @Override
    public void failureFindPeliculas(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}