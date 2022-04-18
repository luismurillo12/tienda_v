package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import com.tienda.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//nos permite que por medio de un URL se ejecute el login en este caso
@Slf4j
public class LoginController {

    @GetMapping("/login") // Para que nos diriga a la pagina principal por medio de / o de /perro
    public String index() { //se ejecute esto que esta aqui 
        return "login";

    }

}
