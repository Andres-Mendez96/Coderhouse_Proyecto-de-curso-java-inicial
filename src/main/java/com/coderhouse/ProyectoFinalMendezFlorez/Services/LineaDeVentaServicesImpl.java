package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Handler.CustomException;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ClienteRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.LineaDeVentaRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ProductoRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaDeVentaServicesImpl implements LineaDeVentaServices {

    @Autowired
    LineaDeVentaRepository lineaDeVentaRepository;

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    ProductoServices productoServices;

    @Autowired
    ClienteRepository clienteRepository;




    @Override
    public List<Linea_De_Venta> buscarTodasLasVentas() {
        return lineaDeVentaRepository.findAll();
    }

    @Override
    public Linea_De_Venta buscarVentaPorId(Integer id_venta) {
        return lineaDeVentaRepository.findById(id_venta).orElse(null);
    }

    @Override
    public LineaVentaResponse vender(LineaVentaRequest venta) throws Exception {

        /*Busco el producto comprado por el cliente y lo almaceno en una variable. Luego se evalua:
        * si el id del cliente es nulo o erroneo, se emite un mensaje de error
        * si el producto es nulo, entonces se emite un mensaje de error*/

        Productos prod = productoRepository.findById(venta.getCodigoProducto()).orElse(null);

        if (verificarCliente(venta.getId_cliente())==false){ throw new CustomException("El cliente no existe");}
        if(prod == null){throw  new CustomException("El producto no existe");}

        //Con la informacion del producto y de la variable venta, se crea la Linea de Venta a guardar
        Linea_De_Venta ventaEntrante;

            ventaEntrante = new Linea_De_Venta().builder()
                    .id_venta(generarId())
                    .codigo(prod.getCodigo())
                    .descripcion(prod.getDescripcion())
                    .precio(prod.getPrecio())
                    .cantidad(venta.getCantidadComprada())
                    .id_comprobante(venta.getNumeroComprobante())
                    .build();

        //Se comprueba que la cantidad solicitada sea menor al stock disponible y se reduce el stock en consecuencia
        if(prod.getStock_disponible() >= venta.getCantidadComprada()){
            int nuevoStock = prod.getStock_disponible() - venta.getCantidadComprada();
            prod.setStock_disponible(nuevoStock);
            productoServices.actualizarProducto(prod);
        } else if (prod.getStock_disponible() < venta.getCantidadComprada()) {
            throw new CustomException("Lo sentimos, pero no hay suficiente stock del producto solicitado para " +
                    "satisfacer la cantidad solicitada.");
        }


        // Se verifica que no se vaya a guardar la venta en una misma linea, sino que sea una diferente
        if (buscarVentaPorId(ventaEntrante.getId_venta()) == null) {
            lineaDeVentaRepository.save(ventaEntrante);

            //Creo un objeto del tipo de mi Response para devolver la información que quiero comunicarle al cliente
            LineaVentaResponse ventaSaliente = new LineaVentaResponse();
            ventaSaliente.setIdVenta(ventaEntrante.getId_venta());
            ventaSaliente.setCodigoProducto(ventaEntrante.getCodigo());
            ventaSaliente.setDescripcionProducto(ventaEntrante.getDescripcion());
            ventaSaliente.setPrecioProducto(ventaEntrante.getPrecio());
            ventaSaliente.setCantidadComprada(ventaEntrante.getCantidad());
            ventaSaliente.setIdComprobante(ventaEntrante.getId_comprobante());

            return ventaSaliente;
        } else throw new CustomException("Esta venta ya había sido registrada");


    }

    //--------------------------- METODOS AUXILIARES --------------------------------------
    private int generarId (){
        return lineaDeVentaRepository.findAll().size()+1;
    }

    private boolean verificarCliente(Integer id_cliente){
        Clientes verificarCliente = clienteRepository.findById(id_cliente).orElse(null);
        if (verificarCliente == null){
            return false;
        } else return true;
    }


}

