
package com.example.U4P3.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Size(max = 60, message = "El subtipo no puede ser tan largo")
    private String subtipo;

    private String texto;

    private String fuerza;

    // Comprueba que la fuerza sea un número o un valor especial como * o *+1.
    @AssertTrue(message = "La fuerza debe tener un formato válido")
    public boolean validarFuerza () {
        if (fuerza == null)
            return true;
        return fuerza.matches("^(\\d+|\\*([+-]\\d+)?)$");
    }

    private String resistencia;

    // Comprueba que la resistencia tenga el mismo formato que la fuerza.
    @AssertTrue(message = "La resistencia debe ser un formato válido")
    public boolean validarResistencia () {
        if (resistencia == null)
            return true;
        return resistencia.matches("^(\\d+|\\*([+-]\\d+)?)$");
    }

    // Permite convertir automáticamente fechas recibidas como yyyy-MM-dd desde el formulario.
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;

    @NotNull
    private boolean legalCommander;

    @NotBlank
    private String imgurl;

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getValorMana() {
        return valorMana;
    }

    public String getSupertipo() {
        return supertipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public String getTexto() {
        return texto;
    }

    public String getFuerza() {
        return fuerza;
    }

    public String getResistencia() {
        return resistencia;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public boolean isLegalCommander() {
        return legalCommander;
    }

    public String getImgurl() {
        return imgurl;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValorMana(String valorMana) {
        this.valorMana = valorMana;
    }

    public void setSupertipo(String supertipo) {
        this.supertipo = supertipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setLegalCommander(boolean legalCommander) {
        this.legalCommander = legalCommander;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
