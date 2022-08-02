package com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse;

import lombok.Data;

@Data
public class LineaVentaRequest {

    //Datos requeridos del cliente:

    private Integer id_cliente;
    private Integer numeroComprobante;

    // Datos requeridos del producto que el cliente desea comprar:
    private Integer codigoProducto;
    private Integer cantidadComprada;

}
