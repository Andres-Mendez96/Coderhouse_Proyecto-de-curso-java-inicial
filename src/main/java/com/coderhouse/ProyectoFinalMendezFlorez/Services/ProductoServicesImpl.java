package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicesImpl implements ProductoServices{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Productos crearProducto(Productos producto) throws Exception {
        if(buscarProductoPorCodigo(producto.getCodigo())==null){
            return productoRepository.save(producto);
        } else {
        throw new  Exception("Este producto ya existe");}
    }

    @Override
    public Productos actualizarProducto(Productos producto) throws Exception {
        if (buscarProductoPorCodigo(producto.getCodigo())!= null){
            return productoRepository.save(producto);
        } else {
            throw new Exception("Este producto no existe");
        }

    }

    @Override
    public List<Productos> buscarTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Productos buscarProductoPorCodigo(Integer codigo) {
        return productoRepository.findById(codigo).orElse(null);
    }
}
