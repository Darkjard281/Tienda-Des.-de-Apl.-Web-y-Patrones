package com.TiendaJarod.dao;

import com.TiendaJarod.domain.Articulo;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author jarod
 */
public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}

