package com.example.P5P6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private String[] visitas = {"Museo", "Parque"};

    @GetMapping("/")
    public String index (Model model) {

        model.addAttribute("visitas", visitas);

        return "index";
    }
}