package com.coderhouse.ProyectoFinalMendezFlorez.Services;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Venta_Comprobante;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteResponse;

import java.util.List;


public interface ComprobanteServices {

    List<Venta_Comprobante> buscarTodos();

    Venta_Comprobante buscarPorId (Integer id_comprobante);

    ComprobanteResponse crear(ComprobanteRequest request) throws Exception;
}
