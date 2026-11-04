package com.example.portfolio;

import jakarta.validation.constraints.*;

public class SolicitudForm {

    @NotBlank(message = "Tienes que poner un titulo al proyecto")
    @Size(max = 60, message = "No tan largo")
    private String titulo;

    @NotNull(message = "¿En qué año lo hiciste?")
    private Integer ano;

    @NotBlank(message = "Selecciona una opción válida")
    @Pattern(regexp = "Aplicaciones|SitiosWeb|Diseno")
    private String categoria;

    @NotBlank(message = "Añade una descripción")
    private String descripcion;

    @NotBlank(message = "Selecciona uno válido")
    @Pattern(regexp = "EnCurso|Terminado")
    private String estado;

    @NotEmpty(message = "Añade al menos una")
    private String[] tecnologias;

    private String enlace;

    private String urlImagen;
}
