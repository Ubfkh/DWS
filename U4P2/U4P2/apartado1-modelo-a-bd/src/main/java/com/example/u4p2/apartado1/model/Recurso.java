package com.example.u4p2.apartado1.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// Indicamos que esta clase es una entidad JPA y que estará representada
// mediante una tabla en la base de datos.
@Entity

// Especificamos que la tabla asociada a esta entidad se llamará "recurso".
@Table(name = "recurso")

// Lombok genera automáticamente los métodos getter para todos los atributos.
@Getter

// Lombok genera automáticamente los métodos setter para todos los atributos.
@Setter

// Lombok genera un constructor sin argumentos, necesario para JPA.
@NoArgsConstructor
public class Recurso {

    // Indicamos que este atributo es la clave primaria de la tabla.
    @Id

    // La base de datos generará automáticamente el identificador
    // cada vez que se inserte un nuevo recurso.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Indicamos que el código del recurso es obligatorio,
    // no puede repetirse y tendrá una longitud máxima de 12 caracteres.
    @Column(nullable = false, unique = true, length = 12)
    private String codigo;

    // Indicamos que el nombre del recurso es obligatorio
    // y tendrá una longitud máxima de 80 caracteres.
    @Column(nullable = false, length = 80)
    private String nombre;

    // Indicamos que la descripción puede contener valores nulos
    // y tendrá una longitud máxima de 250 caracteres.
    @Column(nullable = true, length = 250)
    private String descripcion;

    // Indicamos que el coste de reposición es obligatorio.
    // La precisión 8 establece el número total máximo de dígitos,
    // mientras que la escala 2 establece que habrá dos decimales.
    // Representa el coste económico necesario para sustituir el recurso.
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    // Indicamos que este campo es obligatorio y únicamente puede almacenar
    // true o false. Permite saber si el recurso se puede prestar a los usuarios.
    @Column(nullable = false)
    private boolean prestable;
}
