package com.example.u4p2.apartado2.model;

// Importamos las anotaciones de Jakarta Persistence (JPA)
// necesarias para relacionar la clase con una tabla de la base de datos.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Importamos las anotaciones de Lombok para generar automáticamente
// los métodos getter, setter y el constructor sin argumentos.
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Indicamos que esta clase es una entidad JPA.
// Esto permite que Hibernate gestione su persistencia en la base de datos.
@Entity

// Indicamos el nombre de la tabla de la base de datos
// en la que se almacenarán los objetos de esta clase.
@Table(name = "puesto_trabajo")

// Lombok genera automáticamente los métodos getter
// para todos los atributos de la clase.
@Getter

// Lombok genera automáticamente los métodos setter
// para todos los atributos de la clase.
@Setter

// Lombok genera automáticamente un constructor sin argumentos,
// necesario para que JPA pueda crear instancias de esta entidad.
@NoArgsConstructor
public class PuestoTrabajo {

    // Indicamos que este atributo es la clave primaria (Primary Key)
    // de la tabla puesto_trabajo.
    @Id
    private int id;

    // Indicamos que este campo no puede contener valores nulos,
    // que debe ser único y que tendrá una longitud máxima de 10 caracteres.
    @Column(nullable = false, unique = true, length = 10)
    private String codigo_puesto;

    // Indicamos que este campo no puede contener valores nulos
    // y que tendrá una longitud máxima de 60 caracteres.
    @Column(nullable = false, length = 60)
    private String denominacion;

    // Indicamos que este campo no puede contener valores nulos.
    // Al ser de tipo int, almacena un número entero que representa la planta.
    @Column(nullable = false)
    private int planta;

    // Indicamos que este campo no puede contener valores nulos.
    // Al ser de tipo boolean, permite almacenar true o false
    // para indicar si el puesto de trabajo tiene electricidad.
    @Column(nullable = false)
    private boolean tiene_electricidad;
}
