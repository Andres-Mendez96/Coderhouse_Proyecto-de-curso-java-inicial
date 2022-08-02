package com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse;

import lombok.Data;

@Data
public class LineaVentaRequest {

    //Datos requeridos del cliente:

    private Integer id_cliente;
    private Integer numero;

    // Datos requeridos del producto que el cliente desea comprar:
    private Integer compraNumero;
    private Integer codigoProducto;
    private Integer cantidadComprada;

}
