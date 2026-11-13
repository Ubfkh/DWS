package com.example.u4p2.apartado1.model;// Importamos las anotaciones de Jakarta Persistence para trabajar con JPA.
import jakarta.persistence.*;

// Importamos las anotaciones de Lombok para generar automáticamente
// los métodos getter, setter y el constructor sin argumentos.
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Indicamos que esta clase es una entidad JPA y, por tanto,
// estará representada mediante una tabla en la base de datos.
@Entity

// Especificamos que la tabla asociada a esta entidad se llamará "espacio".
@Table(name = "espacio")

// Lombok genera automáticamente los métodos getter para todos los atributos.
@Getter

// Lombok genera automáticamente los métodos setter para todos los atributos.
@Setter

// Lombok genera un constructor sin argumentos, necesario para JPA.
@NoArgsConstructor
public class Espacio {

    // Indicamos que este atributo es la clave primaria de la tabla.
    @Id

    // La base de datos generará automáticamente el valor del identificador
    // cada vez que se inserte un nuevo espacio.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Indicamos que la columna no puede contener valores nulos,
    // que sus valores deben ser únicos y que tendrá una longitud máxima de 8 caracteres.
    @Column(nullable = false, unique = true, length = 8)
    private String codigo_espacio;

    // Indicamos que este campo es obligatorio y que su longitud máxima
    // en la base de datos será de 60 caracteres.
    @Column(nullable = false, length = 60)
    private String nombre_espacio;

    // Indicamos que el aforo es un campo obligatorio.
    // Al ser de tipo int, almacena el número máximo de personas que admite el espacio.
    @Column(nullable = false)
    private int aforo;

    // Indicamos que la planta es un campo obligatorio.
    // Almacena el número de planta en el que se encuentra el espacio.
    @Column(nullable = false)
    private int planta;

    // Indicamos que la accesibilidad es un campo obligatorio.
    // Al ser boolean, únicamente puede almacenar true o false.
    // Permite indicar si el espacio está adaptado para personas con movilidad reducida.
    @Column(nullable = false)
    private boolean accesible;
}
