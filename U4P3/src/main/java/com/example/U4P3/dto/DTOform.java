package com.example.U4P3.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class DTOform {

    @NotBlank(message = "La carta necesita un nombre")
    @Size(max = 60, message = "El nombre no puede ser tan largo")
    private String nombre;

    @NotBlank(message = "Tienes que poner un valor de maná")
    @Size(max = 60, message = "No tan largo")
    private String valorMana;

    @Size(max = 60, message = "El supertipo no puede ser tan largo")
    private String supertipo;

    @NotBlank(message = "El tipo no puede estar en blanco")
    @Size(max = 60, message = "El tipo no puede ser tan largo")
    private String tipo;

    @NotBlank(message = "El subtipo no puede estar en blanco")
    @Size(max = 60, message = "El subtipo no puede ser tan largo")
    private String subtipo;

    private String texto;

    private String fuerza;

    @AssertTrue(message = "La fuerza debe tener un formato válido")
    public boolean validarFuerza () {
        if (fuerza == null)
            return true;
        return fuerza.matches("^(\\d+|\\*([+-]\\d+)?)$");
    }

    private String resistencia;

    @AssertTrue(message = "La resistencia debe ser un formato válido")
    public boolean validarResistencia () {
        if (resistencia == null)
            return true;
        return resistencia.matches("^(\\d+|\\*([+-]\\d+)?)$");
    }

    @NotNull
    private Date fechaSalida;

    @NotNull
    private boolean legalCommander;

    @NotBlank
    private String imgurl;
}