package com.example.P3P4;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class SolicitudForm {

    //validación de respuestas del formulario
    @NotBlank(message = "Escribe tu nombre")
    @Size(max = 60, message = "El nombre no puede ser tan largo")
    private String nombre;

    @NotBlank(message = "Escribe tu correo")
    @Email(message = "Escribe un correo válido")
    @Size(max = 120, message = "El correo no puede ser tan largo")
    private String email;

    @NotBlank(message = "Selecciona uno")
    @Pattern(regexp = "PORTATIL|MICRO|CAMARA",
             message = "Selecciona uno válido")
    private String material;

    @NotNull(message = "Escribe cuántos quieres")
    @Min(value = 0, message = "No puedes pedir una cantidad negativa")
    private Integer cantidad;

    @NotNull(message = "Tendrás que recogerlo algún día")
    @FutureOrPresent(message = "Qué rápido lo has recogido")
    private LocalDate fechaRecogida;

    @NotNull(message = "Tendrás que devolverlo algún día")
    @FutureOrPresent(message = "Vaya, lo has devuelto muy rápido")
    private LocalDate fechaDevolucion;

    @NotBlank(message = "¿Para qué lo quieres?")
    @Size(min = 60, message = "Desarrolla un poco más")
    @Size(max = 120, message = "Pero no escribas tanto")
    private String motivo;

    @AssertTrue(message = "Tienes que aceptar las normas, blanca flor de invernadero")
    private boolean normas;

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNormas(boolean normas) {
        this.normas = normas;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isNormas() {
        return normas;
    }
}
