package com.coderhouse.ProyectoFinalMendezFlorez.Controller;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/clientes")
public class ClienteController {

    // Inyecto una variable de tipo ClienteServices para conectar esta clase controlador con los servicios
    @Autowired
    ClienteServices clienteServices;

    //Defino los métodos que voy a usar con Get y Post
    @GetMapping("")
    public List<Clientes> buscarTodosLosCLientes (){
        return clienteServices.buscarTodosLosClientes();
    }

    @PostMapping("/crear")
    public Clientes crearCliente (@RequestBody Clientes cliente) throws Exception{
        return clienteServices.crearCliente(cliente);
    }

    @PostMapping("/actualizar")
    public Clientes actualizarCliente (@RequestBody Clientes cliente) throws Exception{
        return clienteServices.crearCliente(cliente);
    }
}
