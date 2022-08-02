package com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse;

import lombok.Builder;
import lombok.Data;
@Data
public class LineaVentaResponse {



        private Integer idVenta;

        private Integer codigoProducto;

        private String descripcionProducto;

        private Float precioProducto;

        private Integer cantidadComprada;

        private Integer idComprobante;

        private String mensaje = "¡Venta Registrada!";
}
