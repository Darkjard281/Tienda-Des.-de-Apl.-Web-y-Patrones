/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.service;

import com.TiendaJarod.dao.RolDao;
import com.TiendaJarod.dao.UsuarioDao;
import com.TiendaJarod.domain.Rol;
import com.TiendaJarod.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jarod
 */
@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RolDao roldao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario us = usuarioDao.findByUsername(username);
        Rol rol = roldao.findById(us.getIdRol()).orElse(null);

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));

        if (rol.getNombre().equals("ROLE_ADMIN") || rol.getNombre().equals("ROLE_VENDEDOR")) {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if (rol.getNombre().equals("ROLE_ADMIN")) {
            roles.add(new SimpleGrantedAuthority("ROLE_VENDEDOR"));
        }

        UserDetails userDet = new User(us.getUsername(), "{noop}" + us.getPassword(), roles);

        return userDet;

    }
}
