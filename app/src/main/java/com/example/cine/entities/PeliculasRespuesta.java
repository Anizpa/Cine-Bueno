package com.example.cine.entities;

import java.util.ArrayList;
import java.util.List;

public class PeliculasRespuesta {
    private List<Peliculas> peliculasList;

    public List<Peliculas> getPeliculasList(){
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
    }
}
