
package com.example.U4P3.controller;

import com.example.U4P3.dto.DTOform;
import com.example.U4P3.model.CartaModel;
import com.example.U4P3.service.CartaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebController {

    // Servicio encargado de gestionar las operaciones relacionadas con las cartas.
    private final CartaService servicio;

    // Inyección de dependencias mediante el constructor.
    public WebController(CartaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/")
    public String index (Model model) {

        // Si no existen cartas en la base de datos, se insertan dos cartas de ejemplo.
        if (servicio.findAll().isEmpty()){
            CartaModel carta = new CartaModel();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = new Date();

            carta.setNombre("Byrke, long ear of the law");
            carta.setValorMana("{4}{W}{G}");
            carta.setSupertipo("Legendary");
            carta.setTipo("Creature");
            carta.setSubtipo("Rabit Soldier");
            carta.setTexto("Vigilance When Byrke enters, put a +1/+1 counter on each of up to two target creatures. Whenever a creature you control with a +1/+1 counter on it attacks, double the number of +1/+1 counters on it");
            carta.setFuerza("4");
            carta.setResistencia("4");
            try {
                fecha = sdf.parse("30/07/2004");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            carta.setFechaSalida(fecha);
            carta.setLegalCommander(true);
            carta.setImgurl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZ9X8dO74url-prziIYPR9ChXYSLEdLds6_pVIklzqfw&s=10");

            servicio.save(carta);

            // Se reutiliza el objeto para introducir la segunda carta de ejemplo.
            carta.setNombre("Ulamog, the Defiler");
            carta.setValorMana("{10}");
            carta.setSupertipo("Legendary");
            carta.setTipo("Creature");
            carta.setSubtipo("Eldrazi");
            carta.setTexto("When you cast this spell, target opponent exiles the top half of their library, rounded up. Ward—Sacrifice two permanents. Ulamog enters with a number of +1/+1 counters on it equal to the greatest mana value among cards in exile. Ulamog has annihilator X, where X is the number of +1/+1 counters on it.");
            carta.setFuerza("7");
            carta.setResistencia("7");
            try {
                fecha = sdf.parse("14/06/2024");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            carta.setFechaSalida(fecha);
            carta.setLegalCommander(true);
            carta.setImgurl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7s5zauiEk-UijbHoGziYZEeI56-zNrAzwWKwtWTcPsQ&s");

            servicio.save(carta);
        }

        // Se envían las cartas y un formulario vacío a la vista index.
        model.addAttribute("cartas", servicio.findAll());
        model.addAttribute("dtoform", new DTOform());

        return "index";
    }

    @PostMapping("/cartas/guardar")
    public String guardar (
            @Valid @ModelAttribute("dtoform") DTOform form,
            BindingResult result,
            Model model) {

        // Si hay errores de validación, se vuelve a mostrar el formulario junto con las cartas.
        if (result.hasErrors()) {
            model.addAttribute("cartas", servicio.findAll());
            return "index";
        }

        // Se crea una entidad y se copian los datos recibidos del formulario.
        CartaModel carta = new CartaModel();

        carta.setNombre(form.getNombre());
        carta.setValorMana(form.getValorMana());
        carta.setSupertipo(form.getSupertipo());
        carta.setTipo(form.getTipo());
        carta.setSubtipo(form.getSubtipo());
        carta.setTexto(form.getTexto());
        carta.setFuerza(form.getFuerza());
        carta.setResistencia(form.getResistencia());
        carta.setFechaSalida(form.getFechaSalida());
        carta.setLegalCommander(form.isLegalCommander());
        carta.setImgurl(form.getImgurl());

        servicio.save(carta);

        // Redirige al inicio para actualizar el listado de cartas.
        return "redirect:/";
    }
}
