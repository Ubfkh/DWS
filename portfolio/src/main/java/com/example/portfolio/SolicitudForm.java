package com.example.portfolio;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class SolicitudForm {

    @NotBlank(message = "Pon un nombre")
    @Size(max = 60, message = "No tan largo")
    private String nombre;

    @NotBlank(message = "Pon una descripción")
    private String descripcion;

    @Email(message = "Pon un formato válido")
    private String contacto;

    private final ArrayList<String> formacion = new ArrayList();
    private final ArrayList<String> formacionDetalle = new ArrayList();

    @AssertTrue(message = "En Formación, rellena los dos campos de cada fila o déjalos vacíos")
    public boolean isFormacionCompleta() {
        for (int i = 0; i < formacion.size(); i++) {
            boolean hayTitulo = !formacion.get(i).isBlank();
            boolean hayDetalle = !formacionDetalle.get(i).isBlank();

            if (hayTitulo != hayDetalle) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> experiencia = new ArrayList();
    private ArrayList<String> experienciaDetalle = new ArrayList();

    @AssertTrue(message = "En Experiencia, rellena los dos campos de cada fila o déjalos vacíos")
    public boolean isExperienciaCompleta() {
        for (int i = 0; i < experiencia.size(); i++) {
            boolean hayTitulo = !experiencia.get(i).isBlank();
            boolean hayDetalle = !experienciaDetalle.get(i).isBlank();

            if (hayTitulo != hayDetalle) {
                return false;
            }
        }
        return true;
    }

    private List<String> nivelesHab = List.of("bajo", "medio", "alto");
    private ArrayList<String> habilidades = new ArrayList();
    private ArrayList<String> habilidadesDetalle = new ArrayList();
    
    @AssertTrue(message = "Hay un error en habilidades")
    public boolean isHabilidadesOK () {
        for (int i=0; i < habilidades.size(); i++){
            boolean hayTitulo = !habilidades.get(i).isBlank();
            boolean hayDetalle = !habilidadesDetalle.get(i).isBlank() && nivelesHab.contains(habilidadesDetalle.get(i));

            if (hayTitulo != hayDetalle) {
                return false;
            }
        }
        return true;
    }

    private List<String> nivelesId = List.of("A1", "A2", "B1", "B2", "C1", "C2", "Nativo");
    private ArrayList<String> idiomas = new ArrayList();
    private ArrayList<String> idiomasDetalle = new ArrayList();

    @AssertTrue(message = "Hay un error en idiomas")
    public boolean isIdiomasOK () {
        for (int i=0; i < idiomas.size(); i++){
            boolean hayTitulo = !idiomas.get(i).isBlank();
            boolean hayDetalle = !idiomasDetalle.get(i).isBlank() && nivelesId.contains(idiomasDetalle.get(i));

            if (hayTitulo != hayDetalle) {
                return false;
            }
        }
        return true;
    }

    private final List<String> categorias = List.of("Diseño", "Sitios Web", "Aplicaciones");
    private final List<String> estados = List.of("En curso", "Terminado");

    private ArrayList<String> proTitulo = new ArrayList();
    private ArrayList<Integer> proAno = new ArrayList();
    private ArrayList<String> proCategoria = new ArrayList();
    private ArrayList<String> proDescripcion = new ArrayList();
    private ArrayList<String> proEstado = new ArrayList();
    private ArrayList<String> proTecnologias = new ArrayList();
    private ArrayList<String> proEnlace = new ArrayList();
    private ArrayList<String> proUrlImagen = new ArrayList();

    @AssertTrue(message = "Hay un error en los proyectos")
    public boolean isProOk () {
        for (int i=0; i < proTitulo.size(); i++){
            boolean hayTitulo = !proTitulo.get(i).isBlank();
            boolean hayAno = !(proAno.get(i) == null);
            boolean hayCategoria = !proCategoria.get(i).isBlank() && categorias.contains(proCategoria.get(i));
            boolean hayDescripcion = !proDescripcion.get(i).isBlank();
            boolean hayEstado = !proEstado.get(i).isBlank() && estados.contains(proEstado.get(i));
            boolean hayTecnologias = !proTecnologias.get(i).isBlank();

            if (hayTitulo != hayAno || hayTitulo != hayCategoria || hayTitulo != hayDescripcion || hayTitulo != hayEstado || hayTitulo != hayTecnologias)
                return false;
        }

        return true;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContacto() {
        return contacto;
    }

    public ArrayList<String> getFormacion() {
        return formacion;
    }

    public ArrayList<String> getFormacionDetalle() {
        return formacionDetalle;
    }

    public ArrayList<String> getExperiencia() {
        return experiencia;
    }

    public ArrayList<String> getExperienciaDetalle() {
        return experienciaDetalle;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public ArrayList<String> getHabilidadesDetalle() {
        return habilidadesDetalle;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public ArrayList<String> getIdiomasDetalle() {
        return idiomasDetalle;
    }

    public ArrayList<String> getProTitulo() {
        return proTitulo;
    }

    public ArrayList<Integer> getProAno() {
        return proAno;
    }

    public ArrayList<String> getProCategoria() {
        return proCategoria;
    }

    public ArrayList<String> getProDescripcion() {
        return proDescripcion;
    }

    public ArrayList<String> getProEstado() {
        return proEstado;
    }

    public ArrayList<String> getProTecnologias() {
        return proTecnologias;
    }

    public ArrayList<String> getProEnlace() {
        return proEnlace;
    }

    public ArrayList<String> getProUrlImagen() {
        return proUrlImagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setExperienciaDetalle(ArrayList<String> experienciaDetalle) {
        this.experienciaDetalle = experienciaDetalle;
    }

    public void setExperiencia(ArrayList<String> experiencia) {
        this.experiencia = experiencia;
    }

    public void setFormacionDetalle(ArrayList<String> formacionDetalle) {
        this.formacionDetalle = formacionDetalle;
    }

    public void setFormacion(ArrayList<String> formacion) {
        this.formacion = formacion;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void setHabilidadesDetalle(ArrayList<String> habilidadesDetalle) {
        this.habilidadesDetalle = habilidadesDetalle;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public void setIdiomasDetalle(ArrayList<String> idiomasDetalle) {
        this.idiomasDetalle = idiomasDetalle;
    }

    public void setProTitulo(ArrayList<String> proTitulo) {
        this.proTitulo = proTitulo;
    }

    public void setProAno(ArrayList<Integer> proAno) {
        this.proAno = proAno;
    }

    public void setProCategoria(ArrayList<String> proCategoria) {
        this.proCategoria = proCategoria;
    }

    public void setProDescripcion(ArrayList<String> proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public void setProEstado(ArrayList<String> proEstado) {
        this.proEstado = proEstado;
    }

    public void setProTecnologias(ArrayList<String> proTecnologias) {
        this.proTecnologias = proTecnologias;
    }

    public void setProEnlace(ArrayList<String> proEnlace) {
        this.proEnlace = proEnlace;
    }

    public void setProUrlImagen(ArrayList<String> proUrlImagen) {
        this.proUrlImagen = proUrlImagen;
    }
}
