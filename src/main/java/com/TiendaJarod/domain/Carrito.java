/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author jarod
 */

@Data
@Entity
@Table(name="carrito")
public class Carrito implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito; 
    private Long idCliente;
    
    public Carrito() {
    }
    public Carrito(Long idCliente) {
        this.idCliente = idCliente;
    }  
}