package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {

    @Autowired //inyectamos la interface donde estan los metodos, este caso esto es nuestro Service
    private IPersonaService personaService;
    @Autowired
    private IPaisService paisService; 

    @GetMapping({"/personas"})
    public String index(Model model) { //nos hace un objeto de tipo model
        List<Persona> listaPersona = personaService.getAllPersona();//nos devuelve una lista de persona
        //esto nos va a permitir que la informacion que tenemos nosotros queramos agrgar a nuestro html se la podamos pasar
        model.addAttribute("titule", "Personas");//cuando el encuntre un titulo lo va a cambiar por una persona
        model.addAttribute("personas", listaPersona);//cuando encuente uno de persona va a cambiarlo por una lista
        return "persona";
    }

    @GetMapping("/personasN/agregar")
    public String crearPersona(Model model) {
        List<Pais> listaPais= paisService.listaCountry(); 
        model.addAttribute("personas", new Persona());//donde vea personas el va a crear un objecto de tipo persona
        model.addAttribute("paises", listaPais); 
        return "crear";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Optional<Persona> persona= personaService.getPersonaById(idPersona);
        List<Pais> listaPais= paisService.listaCountry(); 
        model.addAttribute("personas", persona);
        model.addAttribute("paises", listaPais); 
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona, Model model) {

        personaService.delete(idPersona);
        return "redirect:/persona";

    }

}
