/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//clases de repositorio de la BDS
@Repository //para indicar que va hacer un repositorio 
public interface PaisRepository extends CrudRepository<Pais, Long>{ //Heredamos de CrudRepository y le paso la Entity y la llave primaria
    
}
