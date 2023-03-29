package com.example.cine.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaFicha {

    @SerializedName("idPelicula")
    private int idPelicula;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("sinopsis")
    private String sinopsis;
    @SerializedName("categoria")
    private String categoria;
    @SerializedName("trailer")
    private String trailer;
    @SerializedName("edadRecomendada")
    private int edadRecomendada;
    @SerializedName("valoracion")
    private double valoracion;
    @SerializedName("duracion")
    private int duracion;
    @SerializedName("imagen")
    private String imagen;
    @SerializedName("salas")
    private List<Sala> salas;


    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
