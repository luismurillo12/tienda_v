/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Para saber que es un servcio
public class PersonaService implements IPersonaService{
    //Nos permite hacer una inyeccion de depencias 
    @Autowired
    private PersonaRepository personaRepository; //instanciamos la personaRepository 

    @Override
    public List<Persona> getAllPersona() {
        return(List<Persona>)personaRepository.findAll();// nos devulve una lista de persona por nuestro repositorio
        //esto se optiene de CrudRepository
    }

    @Override
    public int savePersona(Persona persona) {
       int res=0; 
         Persona p= personaRepository.save(persona); // aqui se guarda la persona 
         if (!p.equals(null)) { //que sea diferente a null
             res=1; 
         }
         return res; 
    }

    @Override
    public Optional<Persona> getPersonaById(long id) {
        return personaRepository.findById(id); 
    }

    @Override
    public void delete(long id) {
       personaRepository.deleteById(id);
    }

    @Override
    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre); 
    }
    
}
