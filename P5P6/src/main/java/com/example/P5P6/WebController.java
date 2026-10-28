package com.example.P5P6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private String[][] visitas = {
            {"Museo", "Parque", "Acuario"},
            {"Visita el museo y date una vuelta por todas nuestras obras de arte",
             "Visita el parque y disfruta de numerosas actividades al aire libre",
             "Visita el acuario, donde podrás ver especies marinas que te sorprenderán"}
            };

    @GetMapping("/")
    public String index (Model model) {

        model.addAttribute("visitas", visitas[0]);

        return "index";
    }

    @GetMapping("/visita")
    public String visita (String lugar, Model model) {
        model.addAttribute("lugar", lugar);

        for (int i=0; i < visitas[0].length; i++)
            if (lugar.equalsIgnoreCase(visitas[0][i]))
                model.addAttribute("visita", visitas[1][i]);
        return "visita";
    }
}