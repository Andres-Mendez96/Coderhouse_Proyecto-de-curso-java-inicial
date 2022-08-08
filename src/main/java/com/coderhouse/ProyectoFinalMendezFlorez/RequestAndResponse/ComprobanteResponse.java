package com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ComprobanteResponse {

    private Integer id_comprobante;
    private String fecha;
    private Integer id_cliente;
    private String nombreCompleto;
    private List<Linea_De_Venta> comprasRealizadas;
    private Integer totalArticulos;
    private Float total;
}
