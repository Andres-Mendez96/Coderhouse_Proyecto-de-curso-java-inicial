package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaResponse;

import java.util.List;

public interface LineaDeVentaServices {

    List<Linea_De_Venta> buscarTodasLasVentas ();

    Linea_De_Venta buscarVentaPorId (Integer id_venta);

    LineaVentaResponse vender (LineaVentaRequest venta) throws Exception; // Este metodo guardará una venta en la tabla correspondiente
                                          // y devuelve un aviso al usuario de que ha comprado
}
