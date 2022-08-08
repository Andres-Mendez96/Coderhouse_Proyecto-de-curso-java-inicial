package com.coderhouse.ProyectoFinalMendezFlorez.Controller;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
import com.coderhouse.ProyectoFinalMendezFlorez.Services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/productos")
public class ProductoController {

    //Inyecto la variable productoServices para conectar esta clase controladora con los servicios
    @Autowired
    private ProductoServices productoServices;

    //Defino los metodos get y post
    @GetMapping("/all")
    public List<Productos> buscarTodosLosProductos(){
        return productoServices.buscarTodosLosProductos();
    }

    @PostMapping("/crear")
    public Productos crear (@RequestBody Productos producto) throws Exception{
        return productoServices.crearProducto(producto);
    }

    @PostMapping("/actualizar")
    public Productos actualizar (@RequestBody Productos producto) throws Exception{
        return productoServices.actualizarProducto(producto);
    }
}
