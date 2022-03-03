package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping({"/personas"})
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();//nos devuelve una lista de persona
        model.addAttribute("titule", "Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }

    @GetMapping("/personasN")
    public String crearPersona(Model model) {
        model.addAttribute("personas", new Persona());
        return "crear";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPerosna) {

        personaService.delete(idPerosna);
        return "redirect: /persona";

    }
}
