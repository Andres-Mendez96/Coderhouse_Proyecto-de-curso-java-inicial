package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicesImpl implements ClienteServices{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Clientes crearCliente(Clientes cliente) throws Exception {
        return null;
    }

    @Override
    public Clientes actualizarCliente(Clientes cliente) {
        return null;
    }

    @Override
    public List<Clientes> buscarTodosLosClientes() {
        return clienteRepository.findAll();
    }
}
