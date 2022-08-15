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
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario; // Hibernate lo transforma en id_cliente    String username;
    String username;
    String password;
    Long idCliente;
    Long idRol;

    public Usuario() {
    }

    public Usuario(String username, String password, long idRol) {
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }
}
