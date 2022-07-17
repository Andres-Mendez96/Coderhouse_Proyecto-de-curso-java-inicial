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

        if (buscarPorIdCliente(cliente.getId_cliente())==null){
            return clienteRepository.save(cliente);
        } else  {
            throw new Exception("Este cliente ya existe");
        }

    }

    @Override
    public Clientes actualizarCliente(Clientes cliente) throws Exception {
        if (buscarPorIdCliente(cliente.getId_cliente())!= null){
            return clienteRepository.save(cliente);
        }
        else {
            throw new Exception("Este cliente no existe");
        }
    }


    @Override
    public List<Clientes> buscarTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes buscarPorIdCliente(Integer id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }
}
