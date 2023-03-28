package com.example.cine.entities;

import com.google.gson.annotations.SerializedName;

public class Peliculas {
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
    @SerializedName("visualizaciones")
    private int visualizaciones;
    @SerializedName("valoracion")
    private double valoracion;
    @SerializedName("vecesValorada")
    private int vecesValorada;
    @SerializedName("duracion")
    private int duracion;
    @SerializedName("imagen")
    private String imagen;

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

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public int getVecesValorada() {
        return vecesValorada;
    }

    public void setVecesValorada(int vecesValorada) {
        this.vecesValorada = vecesValorada;
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

    @Override
    public String toString() {
        return "Peliculas{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", categoria='" + categoria + '\'' +
                ", trailer='" + trailer + '\'' +
                ", edadRecomendada=" + edadRecomendada +
                ", visualizaciones=" + visualizaciones +
                ", valoracion=" + valoracion +
                ", vecesValorada=" + vecesValorada +
                ", duracion=" + duracion +
                ", imagen=" + imagen +
                '}';
    }
}
