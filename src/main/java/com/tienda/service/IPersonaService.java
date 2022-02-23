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
    public List<Persona> getAllPersona();
    public void savePersona(Persona persona); 
    public Persona getPersonaById(long id); 
    public void delete(long id);
    
}
