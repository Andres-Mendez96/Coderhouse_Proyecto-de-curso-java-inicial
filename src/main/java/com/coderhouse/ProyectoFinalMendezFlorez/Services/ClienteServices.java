package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;

import java.util.List;

public interface ClienteServices {

    Clientes crearCliente(Clientes cliente) throws Exception;

    Clientes actualizarCliente(Clientes cliente);

    List <Clientes> buscarTodosLosClientes ();
}
