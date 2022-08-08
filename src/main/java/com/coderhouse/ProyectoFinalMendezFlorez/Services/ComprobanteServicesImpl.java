package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Handler.CustomException;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Venta_Comprobante;

import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ClienteRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.ComprobanteRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.Repositories.LineaDeVentaRepository;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComprobanteServicesImpl implements ComprobanteServices{

    @Autowired
    ComprobanteRepository comprobanteRepository;

    @Autowired
    LineaDeVentaRepository lineaDeVentaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Venta_Comprobante> buscarTodos() {

        return comprobanteRepository.findAll();
    }

    @Override
    public Venta_Comprobante buscarPorId(Integer id_comprobante) {
        return comprobanteRepository.findById(id_comprobante).orElse(null);
    }

    @Override
    public ComprobanteResponse crear(ComprobanteRequest request) throws Exception {
        //Proceso para encontrar al cliente
        Clientes cliente = new Clientes();
        if (clienteRepository.findById(request.getId_cliente())!= null){ // Verificacion de si el cliente existe
            cliente = clienteRepository.findById(request.getId_cliente()).orElse(null);
        } else throw new CustomException("¡No existe un cliente con este codigo!");

        //Preparo el nombre completo para luego pasarsela a la variable tipo comprobanteResponse.
        String nombreCompleto = cliente.getNombre() + cliente.getApellido();

        // Obtengo la fecha actual
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
        String fechaComprobante = formatter.format(fecha);

        // Proceso para traer y almacenar todas las lineas de venta
        List<Linea_De_Venta> todasLasLineas = new ArrayList<>();
        todasLasLineas = lineaDeVentaRepository.findAll();

        // Busco las ventas que necesito de acuerdo al numero de comprobante del cliente
        List<Linea_De_Venta> comprasDelCliente = new ArrayList<>();
        for (Linea_De_Venta venta : todasLasLineas){
            int num1 = venta.getId_comprobante();
            int num2 = request.getNumeroComprobante();
            if (num1 == num2){
                comprasDelCliente.add(venta);
            }
        }

        // Calculo el total vendido de todos los productos que compró el cliente.
        Float totalVendido = totalVenta(comprasDelCliente);

        // Calculo el total de unidades vendidas de todos los productos comprados por el cliente
        Integer TotalUnidadesVendidas = totalCantidad(comprasDelCliente);


        /* Una vez se tienen todas las variables que conforman el Response del comprobante, se procede a
        * construir dicho Response*/
        ComprobanteResponse comprobante = new ComprobanteResponse();
        comprobante.setId_comprobante(request.getNumeroComprobante());
        comprobante.setFecha(fechaComprobante);
        comprobante.setId_cliente(request.getId_cliente());
        comprobante.setNombreCompleto(nombreCompleto);
        comprobante.setComprasRealizadas(comprasDelCliente);
        comprobante.setTotal(totalVendido);
        comprobante.setTotalArticulos(TotalUnidadesVendidas);

        /* Se crea y se llena una variable del tipo de la entidad Venta_Comprobante para guardar la informacion
        * en la base de datos*/
        Venta_Comprobante comprobanteParaGuardar = new Venta_Comprobante();

        comprobanteParaGuardar.setId_comprobante(comprobante.getId_comprobante());
        comprobanteParaGuardar.setId_cliente(comprobante.getId_cliente());
        comprobanteParaGuardar.setNombre_Completo(comprobante.getNombreCompleto());
        comprobanteParaGuardar.setFecha(fecha);
        comprobanteParaGuardar.setTotal(comprobante.getTotal());

        comprobanteRepository.save(comprobanteParaGuardar);

        return comprobante;
    }
    // ------------------------------ METODOS AUXILIARES ------------------------------------------
  private Float totalVenta (List<Linea_De_Venta> comprasDelCliente) {
        Float totalVenta = 0F;
        Float precioPorVenta;
        int cantidadComprada;

        for (Linea_De_Venta venta : comprasDelCliente){
            precioPorVenta = venta.getPrecio();
            cantidadComprada = venta.getCantidad();
            totalVenta += (precioPorVenta * cantidadComprada);
        }
        return totalVenta;
  }

  private Integer totalCantidad (List<Linea_De_Venta> comprasDelCliente){
        Integer cantidad = 0;

      for (Linea_De_Venta venta : comprasDelCliente){
          cantidad += venta.getCantidad();
      }

      return cantidad;
  }
}
