package com.coderhouse.ProyectoFinalMendezFlorez.Controller;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.LineaVentaResponse;
import com.coderhouse.ProyectoFinalMendezFlorez.Services.LineaDeVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/ventas")
public class LineaDeVentaController {

    @Autowired
    LineaDeVentaServices lineaDeVentaServices;

    @GetMapping("")
    public String menuPrincipal (){

        return "Menu principal del apartado de ventas \n\n" +

                "Recuerde que la URI principal para acceder a las diferentes funciones es: localhost:8080/ventas \n" +

                "Funciones GET disponibles: \n" +

                "/all: Visualiza todas las ventas realizadas hasta el momento \n" +
                "/id_venta: Busca una venta en funcion de su numero de identificacion \n\n" +

                "Funciones POST disponibles:\n" +
                "/vender: Permite realizar una venta a alguno de los clientes registrados";
    }

    @GetMapping("/all")
    public List<Linea_De_Venta> buscarTodasLasVentas (){
        return lineaDeVentaServices.buscarTodasLasVentas();
    }

    @PostMapping("/vender")
    public LineaVentaResponse vender (@RequestBody LineaVentaRequest request) throws Exception {
        return lineaDeVentaServices.vender(request);
    }
}
