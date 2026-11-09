package com.example.portfolio;

public class Dato {

    private String titulo;
    private String detalle;

    public Dato (String titulo, String detalle) {
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDetalle() {
        return detalle;
    }
}
