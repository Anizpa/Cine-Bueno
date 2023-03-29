package com.example.cine.entities;

import com.google.gson.annotations.SerializedName;

public class Cines {
    @SerializedName("idCine")
    private int idCine;
    @SerializedName("nombre")
    private String nombre;

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
