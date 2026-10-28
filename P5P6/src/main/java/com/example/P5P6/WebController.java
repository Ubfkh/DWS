package com.example.P5P6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    //Esta es la "base de datos" de la que sale la información que se envía al html
    private String[][] visitas = {
            {"museo", "parque", "acuario"},
            {"Visita al museo", "Actividades en el parque", "Tarde en el acuario"},
            {"Visita el museo y date una vuelta por todas nuestras obras de arte",
             "Visita el parque y disfruta de numerosas actividades al aire libre",
             "Visita el acuario, donde podrás ver especies marinas que te sorprenderán"}
            };

    //Esto es lo que se envía si el usuario está en index.html
    @GetMapping("/")
    public String index (Model model) {

        //Mandamos como atributo la primera fila del array
        model.addAttribute("visitas", visitas[0]);

        //indicamos que la página a mostrar es index.html
        return "index";
    }

    //Esto es lo que se envía si el usuario está en visita.html
    @GetMapping("/visita")
    public String visita (String lugar, Model model) {

        //Este for sirve para saber cuál de las visitas es en la que el usuario ha clicado
        for (int i=0; i < visitas[0].length; i++)
            //Una vez sabemos cuál es, volvemos a enviar la visita y su respectiva descripción
            //Esto solo funciona si el array tiene un orden concreto
            if (lugar.equalsIgnoreCase(visitas[0][i])) {
                model.addAttribute("lugar", visitas[0][i]);
                model.addAttribute("visita", visitas[2][i]);
            }
        //Indicamos que la página a mostrar es visita.html
        return "visita";
    }
}