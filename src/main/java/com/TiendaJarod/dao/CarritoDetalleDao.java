/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.dao;

import com.TiendaJarod.domain.Articulo;
import com.TiendaJarod.domain.CarritoDetalle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jarod
 */
public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {

    public Optional<CarritoDetalle> findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);//Sumar en carrito

    public List<CarritoDetalle> findByIdCarrito(Long idCarrito);

    public void deleteByIdCarrito(Long idCarrito);

}
