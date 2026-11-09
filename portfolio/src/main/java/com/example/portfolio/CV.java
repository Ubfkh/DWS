package com.example.portfolio;

import java.util.ArrayList;

public class CV {
    private String nombre;
    private String descripcion;
    private String contacto;
    private ArrayList<Dato> formacion = new ArrayList<>();
    private ArrayList<Dato> experiencia = new ArrayList<>();
    private ArrayList<Dato> habilidades = new ArrayList<>();
    private ArrayList<Dato> idiomas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContacto() {
        return contacto;
    }

    public ArrayList<Dato> getFormacion() {
        return formacion;
    }

    public ArrayList<Dato> getExperiencia() {
        return experiencia;
    }

    public ArrayList<Dato> getHabilidades() {
        return habilidades;
    }

    public ArrayList<Dato> getIdiomas() {
        return idiomas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setFormacion(ArrayList<Dato> formacion) {
        this.formacion = formacion;
    }

    public void setExperiencia(ArrayList<Dato> experiencia) {
        this.experiencia = experiencia;
    }

    public void setHabilidades(ArrayList<Dato> habilidades) {
        this.habilidades = habilidades;
    }

    public void setIdiomas(ArrayList<Dato> idiomas) {
        this.idiomas = idiomas;
    }
}
