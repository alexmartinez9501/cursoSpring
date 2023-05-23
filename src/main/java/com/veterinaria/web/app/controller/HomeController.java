package com.veterinaria.web.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.veterinaria.web.app.model.Vacantes;

@Controller
public class HomeController {
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacantes> lista = getVacantes();
        model.addAttribute("vacante", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacantes vacante = new Vacantes();
        vacante.setNombre("Medico Veterinario");
        vacante.setDescripcion("Se solicita Cirujano canino");
        vacante.setFecha(new Date());
        vacante.setSalario(3700.0);
        model.addAttribute("vacante", vacante);
        return "detalle";

    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<String>();

        lista.add("Medico Veterinario");
        lista.add("Cirujano Veterinario");
        lista.add("Bañador de Perros");
        lista.add("Estilista Canino");
        lista.add("Medico de urgencias");
        lista.add("Nutricionista de Canes de Caza");

        model.addAttribute("empleos", lista);
        return "listado";

    }

    @GetMapping("/")
    public String mostrar(Model model) {

        String nombre = "Cirujano Veterinario";
        Date fechapub = new Date();
        double salario = 5000;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechapub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";
    }

    private List<Vacantes> getVacantes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacantes> lista = new LinkedList<Vacantes>();
        try {
            Vacantes vacante1 = new Vacantes();

            vacante1.setId(1);
            vacante1.setNombre("Estelista canino");
            vacante1.setDescripcion(
                    "Se solicita estilista para realizar baños ,cortes de uña y pelaje de caninos grandes");
            vacante1.setFecha(sdf.parse("08-09-2023"));
            vacante1.setSalario(350.0);
            vacante1.setDestacado(0);
            vacante1.setImagen("veterinaria1.png");

            // Oferta de Trabajo 2
            Vacantes vacante2 = new Vacantes();
            vacante2.setId(2);
            vacante2.setNombre("Estilista Gatuno");
            vacante2.setDescripcion("Se solicita estilista para realizar baños ,cortes de uña y pelaje de felinos");
            vacante2.setFecha(sdf.parse("09-09-2023"));
            vacante2.setSalario(250.0);
            vacante2.setDestacado(1);
            vacante2.setImagen("veterinaria2.jpg");

            // Oferta de trabajo 3
            Vacantes vacante3 = new Vacantes();
            vacante3.setId(3);
            vacante3.setNombre("Medico Cirujano");
            vacante3.setDescripcion("Se solicita medico especialista en cirujas caninas y felinas");
            vacante3.setFecha(sdf.parse("04-06-2023"));
            vacante3.setSalario(450.0);
            vacante3.setDestacado(0);
            vacante3.setImagen("veterinaria3.jpg");

            // oferta de trabajo 4
            Vacantes vacante4 = new Vacantes();
            vacante4.setId(4);
            vacante4.setNombre("Asitente");
            vacante4.setDescripcion("Se solicita Asistente especializada(o) en cirugias caninas y felinas");
            vacante4.setFecha(sdf.parse("03-05-2023"));
            vacante4.setSalario(250.0);
            vacante4.setDestacado(1);
            vacante4.setImagen("veterinaria4.jpg");

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);
        } catch (ParseException e) {
            System.out.print("Error:" + e.getMessage());
        }
        return lista;

    }

}
