/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.service;

import com.TiendaJarod.domain.Articulo;
import com.TiendaJarod.domain.CarritoDetalle;
import java.util.List;

/**
 *
 * @author jarod
 */
public interface CarritoDetalleService {

    CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);

    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);

    public void save(CarritoDetalle carritoDetalle);

    public void delete(CarritoDetalle carritoDetalle);

    public void deleteAll(Long idCarrito);
}
