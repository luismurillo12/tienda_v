/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author luisn
 */
public interface IPersonaService {
    public List<Persona> getAllPersona();//nos devuelve una lista de personas 
    public void savePersona(Persona persona); //guardamos a una persona 
    public Persona getPersonaById(long id); //le pasamos el id de la persona y esto nos devuelve una persona 
    public void delete(long id); //le pasamos el id y no elimia por medio de este 
    
}
