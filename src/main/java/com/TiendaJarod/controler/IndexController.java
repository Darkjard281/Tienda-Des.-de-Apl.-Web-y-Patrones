package com.TiendaJarod.controler;

import com.TiendaJarod.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.TiendaJarod.domain.Cliente;
import com.TiendaJarod.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller/*Nos permite utilizar la funciones de un controlador*/
@Slf4j/*Registro de bitacoras en el output*/

public class IndexController { //Servidor busca un controlador que se llame index omite lo que dice controler

    @Autowired//Si no se ha instanciado en esta clase un objeto de este tipo el automaticamente lo hace
    private ClienteService clienteService; 
    
    @GetMapping("/")/*AccionDefault*/
    public String inicio(Model model) {//Con el podemos mandar a los documentos html(index) un objeto model
        log.info("Ahora utilizamos MVC");//Enlazado con SLF4J
        /*
        var mensaje = "Estamos en la semana 4";
        model.addAttribute("mensaje", mensaje);//Nombre de la variable a pasar/ tipo de variable
   
        Cliente cliente1 = new Cliente("Jarod", "Viquez Salazar", "jarod281@hotmail.com", "8480-6994");
        Cliente cliente2 = new Cliente("Allison", "Viquez", "alli@", "xxxx");
        Cliente cliente3 = new Cliente("Yesenia", "XXXXX", "yesi@", "xxxx");
        
        var clientes = Arrays.asList(cliente1, cliente2, cliente3);//Importar Java util para agragar array
        
        model.addAttribute("cliente", cliente1);
        model.addAttribute("clientes",clientes);
        */
        
        /* Ejemplo 2 editado
        Cliente cliente = new Cliente();
        cliente.setIdCliente(Long.parseLong("1"));
        var temp = clienteService.getCliente(cliente);
        model.addAttribute("temp",temp);
        */
        
        var clientes = clienteService.getClientes();//Busca todos los objetos de tipo cliente en la base de datos y los guarda en el var
        model.addAttribute("clientes",clientes);
        return "index";/*Buscar en templates una vista llamada index*/ 
    
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
    cliente = clienteService.getCliente(cliente);
    model.addAttribute("cliente", cliente);
    return "modificarCliente";
    
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
    clienteService.delete(cliente);
    return "redirect:/";
    }
}
