package com.example.portfolio;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WebController {

    private boolean iniciado = false;

    private CV cv = new CV();

    private ArrayList<Proyecto> proyectos = new ArrayList();

    private final String[] categorias = {"Todos", "Aplicaciones", "Sitios Web", "Diseño"};
    private final String[] nivelesHab = {"bajo", "medio", "alto", ""};
    private final String[] nivelesId = {"A1", "A2", "B1", "B2", "C1", "C2", "Nativo", ""};

    @GetMapping("/")
    public String inicio (Model model) {

        if (!iniciado){
            cv.setNombre("Lope");
            cv.setDescripcion("Estudiante de DAW, desarrollo de aplicaciones web");
            cv.setContacto("martinezgarcialope@gmail.com");

            cv.getFormacion().add(new Dato("Bachillerato tecnológico", "IES Gerena 2023 - 2025"));
            cv.getFormacion().add(new Dato("DAW", "IES Julio Verne // IES Velazquez 2025 - actualidad"));

            cv.getExperiencia().add(new Dato("Prácticas en Ayesa", "05/2026 - 06/2026"));

            cv.getHabilidades().add(new Dato("Habilidad 1", "medio"));
            cv.getHabilidades().add(new Dato("Habilidad 2", "bajo"));
            cv.getHabilidades().add(new Dato("Habilidad 3", "alto"));

            cv.getIdiomas().add(new Dato("Español", "Nativo"));
            cv.getIdiomas().add(new Dato("Inglés", "B1"));

            iniciado = true;
        }

        return "index";
    }

    @GetMapping("/curriculum")
    public String curriculum (Model model){

        model.addAttribute("cv", cv);

        return "curriculum";
    }

    @GetMapping("/portfolio")
    public String portfolio (@RequestParam(defaultValue = "Todos") String categoria, Model model){

        if (proyectos.isEmpty()) {
            proyectos.add(new Proyecto("p1", 2026, "Sitios Web", "Es el proyecto 1", "Terminado", "Java, SpringBoot"));
            proyectos.add(new Proyecto("p2", 2026, "Diseño", "Es el proyecto 2", "Terminado", "HTML, CSS, BootStrap"));
            proyectos.add(new Proyecto("p3", 2026, "Sitios Web", "Es el proyecto 3", "En curso", "java, SpringBoot"));
        }

        if (categoria.equals("Todos"))
            model.addAttribute("proyectos", proyectos);
        else {
            ArrayList proyectosFiltrado = new ArrayList();

            for (Proyecto p: proyectos){
                if (categoria.equals(p.getCategoria()))
                    proyectosFiltrado.add(p);
            }

            model.addAttribute("proyectos", proyectosFiltrado);
        }

        model.addAttribute("categorias", categorias);
        model.addAttribute("categoriaSelec", categoria);

        return "portfolio";
    }

    @GetMapping("/portfolio/editar")
    public String editar (Model model){
        model.addAttribute("cv", cv);
        model.addAttribute("nivelesHab", nivelesHab);
        model.addAttribute("nivelesId", nivelesId);

        return "editar";
    }

    @PostMapping("/portfolio/editar")
    public String guardar (@Valid @ModelAttribute("form") SolicitudForm form, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("cv", cv);
            return "editar";
        }

        cv.setNombre(form.getNombre());
        cv.setDescripcion(form.getDescripcion());
        cv.setContacto(form.getContacto() != null ? form.getContacto() : "");

        cv.setFormacion(new ArrayList());
        for (int i=0; i < form.getFormacion().size(); i++){
            if (!form.getFormacion().get(i).isBlank())
                cv.getFormacion().add(new Dato(form.getFormacion().get(i), form.getFormacionDetalle().get(i)));
        }

        cv.setExperiencia(new ArrayList());
        for (int i=0; i < form.getExperiencia().size(); i++){
            if (!form.getExperiencia().get(i).isBlank())
                cv.getExperiencia().add(new Dato(form.getExperiencia().get(i), form.getExperienciaDetalle().get(i)));
        }

        cv.setHabilidades(new ArrayList());
        for (int i=0; i < form.getHabilidades().size(); i++){
            if (!form.getHabilidades().get(i).isBlank())
                cv.getHabilidades().add(new Dato(form.getHabilidades().get(i), form.getHabilidadesDetalle().get(i)));
        }

        cv.setIdiomas(new ArrayList());
        for (int i=0; i < form.getIdiomas().size(); i++){
            if (!form.getIdiomas().get(i).isBlank())
                cv.getIdiomas().add(new Dato(form.getIdiomas().get(i), form.getIdiomasDetalle().get(i)));
        }

        proyectos = new ArrayList();

        for (int i=0; i < form.getProTitulo().size(); i++){
            Proyecto p = null;

            if (!form.getProTitulo().get(i).isBlank()){
                p = new Proyecto(form.getProTitulo().get(i), form.getProAno().get(i), form.getProCategoria().get(i), form.getProDescripcion().get(i), form.getProEstado().get(i), form.getProTecnologias().get(i));


                if (!form.getProEnlace().get(i).isBlank()){
                    p.setEnlace(form.getProEnlace().get(i));
                }

                if (!form.getProUrlImagen().get(i).isBlank()){
                    p.setUrlImagen(form.getProUrlImagen().get(i));
                }

                proyectos.add(p);
            }
        }

        return "redirect:/";
    }
}