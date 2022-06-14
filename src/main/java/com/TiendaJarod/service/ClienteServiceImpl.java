/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.service;

import com.TiendaJarod.dao.ClienteDao;
import com.TiendaJarod.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jarod
 */
@Service/*Pass through de ClienteService*/
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();//Se hace usa un cast para convertir la lista iterable
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
     clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
      clienteDao.delete(cliente);
    }
    
}
