package com.example.springBoot;

// Importamos la clase necesaria para iniciar Spring Boot.
import org.springframework.boot.SpringApplication;

// Permite configurar automáticamente la aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indica que esta es la clase principal de la aplicación.
@SpringBootApplication
public class SpringbootApplication {

    // Punto de entrada del programa Java.
    public static void main(String[] args) {

        // Inicia Spring Boot y pone en marcha el servidor web.
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
