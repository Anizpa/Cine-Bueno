package com.example.cine.entities;

public class ListPeliculasRequest {
    private String titulo;
    private String categoria;
    private int edadRecomendada;
    private double valoracion;
    private int limite;
    private int id;
    private String imagen;

    public ListPeliculasRequest(String titulo, String categoria, int edadRecomendada,
                                double valoracion, int limite, int id, String imagen) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.edadRecomendada = edadRecomendada;
        this.valoracion = valoracion;
        this.limite = limite;
        this.id = id;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
