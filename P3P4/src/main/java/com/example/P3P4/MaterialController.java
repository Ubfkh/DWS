package com.example.P3P4;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class MaterialController {

    private final String [][] materiales = {
            {"PORTATIL", "Portátil", "Ordenador portátil"},
            {"MICRO", "Micrófono", "Micrófono para grabaciones"},
            {"CAMARA", "Cámara", "Cámara digital"}
    };

    @GetMapping("/")
    public String catalogo (Model model){
        model.addAttribute("materiales", materiales);
        return "catalogo";
    }

    private String[] buscarMaterial (String codigo) {
        String [] devuelta = null;

        for (String [] material : materiales){
            if (material[0].equalsIgnoreCase(codigo)){
                devuelta = material;
            }
        }

        return devuelta;
    }

    @GetMapping("/materiales/{codigo}")
    public String detalle (
            @PathVariable String codigo,
            @RequestParam(defaultValue = "general") String turno,
            Model model) {
        String[] material = buscarMaterial(codigo);

        if (material == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("material", material);
        model.addAttribute("turno", turno);

        return "detalle";
    }

    @GetMapping("/solicitud/nueva")
    public String nuevaSolicitud (Model model){
        model.addAttribute("solicitudForm", new SolicitudForm());
        model.addAttribute("materiales", materiales);
        model.addAttribute("hoy", LocalDate.now());

        return "solicitud";
    }

    private long calcularDias (LocalDate recogida, LocalDate devolucion){
        return ChronoUnit.DAYS.between(recogida, devolucion) + 1;
    }

    @PostMapping("/solicitudes")
    public String procesarSolicitud (
            @Valid @ModelAttribute("solicitudForm") SolicitudForm formulario,
            BindingResult bindingResult,
            Model model) {

        boolean error = false;

        if (formulario.getFechaRecogida() != null
                && formulario.getFechaDevolucion() != null
                && formulario.getFechaDevolucion().isBefore(formulario.getFechaRecogida())){
            bindingResult.rejectValue(
                    "fechaDevolucion",
                    "fechaDevolucionInvalida",
                    "No puedes devolverlo sin siquiera haber ido a recogerlo"
            );
        }



        if (bindingResult.hasErrors()){
            model.addAttribute("materiales", materiales);
            model.addAttribute("hoy", LocalDate.now());

            return "solicitud";
        } else {
            long diasPrestamo = calcularDias(
                    formulario.getFechaRecogida(),
                    formulario.getFechaDevolucion()
            );

            int totalDiasUnidad = (int) (diasPrestamo * formulario.getCantidad());

            model.addAttribute("solicitud", formulario);
            model.addAttribute("diasPrestamo", diasPrestamo);
            model.addAttribute("totalDiasUnidad", totalDiasUnidad);

            String[] material = buscarMaterial(formulario.getMaterial());
            model.addAttribute("material", material);

            return "resultado";
        }
    }
}
