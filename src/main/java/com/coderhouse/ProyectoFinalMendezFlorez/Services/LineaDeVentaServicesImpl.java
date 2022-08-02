package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Handler.CustomException;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ClienteRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.LineaDeVentaRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ProductoRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaRequest;
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
    public Linea_De_Venta vender(LineaVentaRequest venta) throws Exception {

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


            // Se verifica que no se vaya a guardar la venta en una misma linea, sino que sea una diferente
        if (buscarVentaPorId(ventaEntrante.getId_venta()) == null) {
            lineaDeVentaRepository.save(ventaEntrante);
            return ventaEntrante;
        } else throw new CustomException("Esta venta ya había sido registrada");


    }

    //--------------------------- METODOS --------------------------------------
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

