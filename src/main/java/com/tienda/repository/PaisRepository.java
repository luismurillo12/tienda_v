/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luisn
 */
public interface PaisRepository extends CrudRepository<Pais, Long>{
    
}
