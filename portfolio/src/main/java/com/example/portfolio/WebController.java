package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class WebController {

    private String [][] datosCV = {
            {"Perfil", "Lope", "Estudiante de DAW, desarrollo de aplicaciones web"},
            {"Contacto", "martinezgarcialope@gmail.com"},
            {"Formación", "Bachillerato tecnológico", "DAW"},
            {"Formación_AUX", "IES Gerena 2023 - 2025", "IES Julio Verne // IES Velazquez 2025 - actualidad"},
            {"Experiencia", "Prácticas en Ayesa"},
            {"Experiencia_AUX", "05/2026 - 06/2026"},
            {"Habilidades"},
            {"Habilidades_AUX"},
            {"Idiomas", "Español", "Inglés"},
            {"Idiomas_AUX", "Nativo", "Nivel B1"}
    };

    private ArrayList<Proyecto> proyectos = new ArrayList();

    @GetMapping("/")
    public String inicio (Model model) {

        return "index";
    }

    @GetMapping("/curriculum")
    public String curriculum (Model model){

        model.addAttribute("datos", datosCV);

        return "curriculum";
    }

    @GetMapping("/portfolio")
    public String portfolio (Model model){

        if (proyectos.isEmpty()) {
            proyectos.add(new Proyecto("p1", 2026, "Aplicaciones", "Es el proyecto 1", "Terminado", new String[]{"Java", "SpringBoot"}));
            proyectos.add(new Proyecto("p2", 2026, "Diseño", "Es el proyecto 2", "Terminado", new String[]{"HTML", "CSS", "BootStrap"}));
            proyectos.add(new Proyecto("p3", 2026, "Sitios Web", "Es el proyecto 3", "En curso", new String[]{"java", "SpringBoot"}));
        }

        model.addAttribute("proyectos", proyectos);

        return "portfolio";
    }


}