/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author luisn
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();//nos devuelve una lista de personas 
    public int savePersona(Persona persona); //guardamos a una persona 
    public Optional<Persona> getPersonaById(long id); //le pasamos el id de la persona y esto nos devuelve una persona 
    public void delete(long id); //le pasamos el id y no elimia por medio de este 
    public Persona findByNombre(String nombre);
    
}
