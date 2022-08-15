/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.dao;

import com.TiendaJarod.domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jarod
 */

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
    Usuario findByUsernameAndPassword(String username,String password);
    
    List<Usuario> findByIdRol(Long IdRol);
}
