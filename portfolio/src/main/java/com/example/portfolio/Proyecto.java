package com.example.portfolio;

public class Proyecto {
    private String titulo;
    private int ano;
    private String categoria;
    private String descripcion;
    private String estado;
    private String tecnologias;
    private String enlace;
    private String urlImagen;

    public Proyecto(String titulo, int ano, String categoria, String descripcion, String estado, String tecnologias) {
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tecnologias = tecnologias;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getAno() {
        return ano;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getEnlace() {
        return enlace;
    }

    public String[] getTecnologias() {
        return tecnologias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }
}
