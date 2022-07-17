package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;

import java.util.List;

public interface ClienteServices {

    Clientes crearCliente(Clientes cliente) throws Exception;

    Clientes actualizarCliente(Clientes cliente) throws Exception;

    List <Clientes> buscarTodosLosClientes ();

    Clientes buscarPorIdCliente (Integer id_cliente);
}
