package com.example.cine.entities;

import com.google.gson.annotations.SerializedName;

public class Sala {
    @SerializedName("idSala")
    private int idSala;
    @SerializedName("nombreCine")
    private String nombreCine;
    @SerializedName("horario")
    private String horario;
    @SerializedName("butacas")
    private int butacas;
    @SerializedName("titulo")
    private String titulo;

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getButacas() {
        return butacas;
    }

    public void setButacas(int butacas) {
        this.butacas = butacas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
