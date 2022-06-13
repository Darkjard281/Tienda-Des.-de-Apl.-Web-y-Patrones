/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaJarod.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;//Libreria que nos ayuda con los Getter and Setter notacion @Data


@Data//Notacion de lombok me da metodos como los getter and setters
@Entity/*Importar javax.persitence*/
@Table(name="cliente")/*La clase cliente va a hacer referencia a la tabla cliente que se encuentra en base de datos*/
public class Cliente implements Serializable{/*Para que el objeto se pueda serializar*/
    
    private static final long serialVersionUID = 1L;/*Configuracion defaul para hybernate*/
    
    @Id/*Llave primaria para la base de datos*/
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idCliente; // El motor que tenemos de ORM llamado hibernate lo interpreta como id_cliente
    
    String nombre,apellidos,correo,telefono;
    
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

}
