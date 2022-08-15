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
@Table(name="carrito_detalle")
public class CarritoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle; 
    private Long idCarrito;    
    private double precio; 
    private int cantidad; 
    
    @JoinColumn(name="id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne    
    private Articulo articulo;
    
    public CarritoDetalle() {
    }
    
    public CarritoDetalle(Long idCarrito, double precio, int cantidad, Articulo articulo) {
        this.idCarrito = idCarrito;
        this.precio = precio;
        this.cantidad = cantidad;
        this.articulo = articulo;
    }
}
