package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private String [][] datos = {
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

    @GetMapping("/")
    public String inicio (Model model) {

        model.addAttribute("datos", datos);

        return "index";
    }
}