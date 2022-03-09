package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Clase para las entidades donde se va a guardar la informacion que viene de la BD

@Entity //para inidicar que esta clase es una entidad 
@Table(name="paises") // va a guardar infmoracion de la tabla que se llama paises
public class Pais implements Serializable {
    @Id //para indicar que nuestro id es nuestra llave primaria 
    @GeneratedValue(strategy=GenerationType.IDENTITY)//se va a ingresando los datos incrementando uno+
    //los atributos de nuestra base de datos
    
    private long id;
    private String pais; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
