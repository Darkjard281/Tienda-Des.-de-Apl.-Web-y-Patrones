/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.dao;

import com.TiendaJarod.domain.Credito;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author jarod
 */
public interface CreditoDao extends CrudRepository<Credito, Long>{
    
}
