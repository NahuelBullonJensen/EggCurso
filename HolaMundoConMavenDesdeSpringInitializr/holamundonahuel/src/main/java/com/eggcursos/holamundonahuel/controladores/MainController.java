/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggcursos.holamundonahuel.controladores;

import com.eggcursos.holamundonahuel.entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nahue
 */
@Controller
@RequestMapping("/")
public class MainController {
    
    List<Persona> personas = new ArrayList<>();
    
    @GetMapping("")
    public String holaMundo(Model model) {
        if (personas.isEmpty()) {
            personas.add(new Persona("Nahuel","Bullón",25));
            personas.add(new Persona("Milagros", "Fontecha",26));
            personas.add(new Persona("Flavia", "Cipolla",29));
        } 
        model.addAttribute("tittle", "Probando thymeleaf");
        model.addAttribute("personas",personas);
        return "index";
    }
    
    @GetMapping("/crearpersona")
    public String crearPersona() {
        return "persona-form";
    }
    
    @PostMapping("/guardarpersona")
    public String guardarPersona(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer edad) {
        Persona persona = new Persona(nombre, apellido, edad);
        personas.add(persona);
        return "redirect:/";
    }
}
