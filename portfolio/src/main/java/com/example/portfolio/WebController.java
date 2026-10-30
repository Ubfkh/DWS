package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    

    @GetMapping("/")
    public String inicio (Model model) {

        return "index";
    }
}