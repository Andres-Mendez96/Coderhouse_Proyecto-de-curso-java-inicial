package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;

import java.util.List;

public interface ProductoServices {

    Productos crearProducto (Productos producto) throws Exception;

    Productos actualizarProducto(Productos producto) throws Exception;

    List <Productos> buscarTodosLosProductos ();

    Productos buscarProductoPorCodigo (Integer codigo);
}
