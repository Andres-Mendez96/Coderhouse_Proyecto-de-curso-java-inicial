package com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse;


import lombok.Data;
@Data
public class LineaVentaResponse {



        private Integer idVenta;

        private Integer codigoProducto;

        private String descripcionProducto;

        private Float precioProducto;

        private Integer cantidadComprada;

        private Integer idComprobante;

        private String mensaje = "¡Venta Registrada!" + "Si esta es su ultima compra, por favor genere su comprobante en la URI: " +
                                   "http://localhost:8080/coderhouse/comprobante/crear";
}
