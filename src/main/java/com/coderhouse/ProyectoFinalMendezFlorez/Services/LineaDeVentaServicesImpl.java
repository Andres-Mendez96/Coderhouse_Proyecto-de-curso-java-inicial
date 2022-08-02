package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
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

        //Busco el producto comprado por el cliente y lo almaceno en una variable.
        Productos prod = productoRepository.findById(venta.getCodigoProducto()).orElse(null);

        //Con la informacion del producto y de la variable venta, se crea la Linea de Venta a guardar
        Linea_De_Venta ventaEntrante;

            ventaEntrante = new Linea_De_Venta().builder()
                    .id_venta(venta.getCompraNumero())
                    .codigo(prod.getCodigo())
                    .descripcion(prod.getDescripcion())
                    .precio(prod.getPrecio())
                    .cantidad(venta.getCantidadComprada())
                    .id_comprobante(venta.getNumero())
                    .build();



        if (buscarVentaPorId(ventaEntrante.getId_venta()) == null) {
            lineaDeVentaRepository.save(ventaEntrante);
            return ventaEntrante;
        } else throw new Exception("Esta venta ya había sido registrada");


        //---------------------------------------------------------------------------------
        /*
        if (buscarVentaPorId(venta.getId_venta())==null){
            lineaDeVentaRepository.save(venta);
            return "¡Venta registrada!";
        } else throw new Exception("Esta venta ya ha sido registrada antes");
        // Intentar verificar si el cliente existe usando el atributo venta_comprobante-fk

         */

    }
}
