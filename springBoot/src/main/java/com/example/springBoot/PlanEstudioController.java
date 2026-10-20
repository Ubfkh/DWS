package com.example.springBoot;

// Importamos List para crear listas de asignaturas y duraciones.
import java.util.List;

// Importamos las anotaciones de Spring MVC.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanEstudioController {

    // Atiende las peticiones GET que llegan a la dirección principal "/".
    @GetMapping("/")
    public String mostrarPlan(

            // Recibe el parámetro "nombre" de la URL.
            // required = false permite acceder sin indicar ningún nombre.
            @RequestParam(required = false) String nombre,

            // Model permite enviar datos desde Java a la plantilla HTML.
            Model model) {

        // Si no se indica un nombre o está vacío, usamos uno predeterminado.
        if (nombre == null || nombre.isBlank()) {
            nombre = "estudiante";
        }

        // Creamos una lista con las asignaturas del día.
        // No necesitamos crear una clase propia para representarlas.
        List<String> asignaturas = List.of(
                "Programación",
                "Bases de datos",
                "Lenguajes de marcas"
        );

        // Creamos otra lista con la duración de cada asignatura en minutos.
        // Cada posición corresponde a la asignatura de la misma posición.
        List<Integer> duraciones = List.of(25, 40, 30);

        // Sumamos todas las duraciones para obtener el tiempo total de estudio.
        int totalMinutos = duraciones.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // Enviamos el nombre a la plantilla Thymeleaf.
        model.addAttribute("nombre", nombre);

        // Enviamos la lista de asignaturas.
        model.addAttribute("asignaturas", asignaturas);

        // Enviamos la lista de duraciones.
        model.addAttribute("duraciones", duraciones);

        // Enviamos el total de minutos.
        model.addAttribute("totalMinutos", totalMinutos);

        // Indicamos la plantilla que debe mostrar Spring Boot.
        // Corresponde al archivo templates/plan-estudio.html.
        return "plan-estudio";
    }
}
