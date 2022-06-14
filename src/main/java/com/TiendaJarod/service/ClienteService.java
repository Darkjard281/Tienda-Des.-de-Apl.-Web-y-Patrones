/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.service;

import com.TiendaJarod.domain.Cliente;
import java.util.List;

/**
 *
 * @author jarod
 */
public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save (Cliente cliente);
    
    public void delete(Cliente cliente);
    
}
