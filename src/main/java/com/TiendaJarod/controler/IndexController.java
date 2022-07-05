package com.TiendaJarod.controler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.TiendaJarod.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller/*Nos permite utilizar la funciones de un controlador*/
@Slf4j/*Registro de bitacoras en el output*/

public class IndexController { //Servidor busca un controlador que se llame index omite lo que dice controler

    @Autowired//Si no se ha instanciado en esta clase un objeto de este tipo el automaticamente lo hace
    private ArticuloService articuloService;

    @GetMapping("/")/*AccionDefault*/
    public String inicio(Model model) {//Con el podemos mandar a los documentos html(index) un objeto model
        log.info("Ahora utilizamos MVC");//Enlazado con SLF4J

        var articulos = articuloService.getArticulos(true);//Busca todos los objetos de tipo cliente en la base de datos y los guarda en el var
        model.addAttribute("articulos", articulos);
        return "index";/*Buscar en templates una vista llamada index*/

    }

}
