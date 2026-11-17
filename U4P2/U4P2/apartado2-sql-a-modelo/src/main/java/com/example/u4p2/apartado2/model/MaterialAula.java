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

// Importamos BigDecimal para almacenar valores decimales con precisión,
// especialmente útil para representar cantidades económicas.
import java.math.BigDecimal;

// Indicamos que esta clase es una entidad JPA.
// Esto permite que Hibernate gestione su persistencia en la base de datos.
@Entity

// Indicamos que la tabla asociada a esta entidad
// tendrá el nombre "material_aula".
@Table(name = "material_aula")

// Lombok genera automáticamente los métodos getter
// para todos los atributos de la clase.
@Getter

// Lombok genera automáticamente los métodos setter
// para todos los atributos de la clase.
@Setter

// Lombok genera automáticamente un constructor sin argumentos,
// necesario para que JPA pueda crear instancias de esta entidad.
@NoArgsConstructor
public class MaterialAula {

    // Indicamos que este atributo es la clave primaria (Primary Key)
    // de la tabla material_aula.
    @Id
    private int id;

    // Indicamos que este campo no puede contener valores nulos,
    // que su contenido debe ser único y que tendrá una longitud
    // máxima de 12 caracteres.
    @Column(nullable = false, unique = true, length = 12)
    private String referencia;

    // Indicamos que este campo no puede contener valores nulos
    // y que tendrá una longitud máxima de 80 caracteres.
    // Almacena el nombre del material del aula.
    @Column(nullable = false, length = 80)
    private String nombre_material;

    // Indicamos que este campo puede contener valores nulos
    // y que tendrá una longitud máxima de 250 caracteres.
    // Almacena una descripción del material.
    @Column(length = 250)
    private String descripcion;

    // Indicamos que este campo no puede contener valores nulos.
    // Utilizamos BigDecimal para almacenar valores decimales
    // con precisión, evitando errores habituales de los tipos float y double.
    // precision = 8 indica que puede tener hasta 8 dígitos en total.
    // scale = 2 indica que puede tener hasta 2 cifras decimales.
    // Almacena el coste necesario para reponer el material.
    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal coste_reposicion;

    // Indicamos que este campo no puede contener valores nulos.
    // Al ser de tipo short, almacena un número entero pequeño.
    // Representa la cantidad de unidades disponibles del material.
    @Column(nullable = false)
    private short unidades;
}