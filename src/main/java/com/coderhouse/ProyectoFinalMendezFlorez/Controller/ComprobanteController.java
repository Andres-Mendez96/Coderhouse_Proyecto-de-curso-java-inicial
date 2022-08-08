package com.coderhouse.ProyectoFinalMendezFlorez.Controller;

import com.coderhouse.ProyectoFinalMendezFlorez.Handler.CustomException;
import com.coderhouse.ProyectoFinalMendezFlorez.Models.Venta_Comprobante;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteRequest;
import com.coderhouse.ProyectoFinalMendezFlorez.RequestAndResponse.ComprobanteResponse;
import com.coderhouse.ProyectoFinalMendezFlorez.Services.ComprobanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/coderhouse/comprobante")
public class ComprobanteController {

    @Autowired
    ComprobanteServices comprobanteServices;

    @GetMapping("")
    public String menuPrincipal (){
        return "Bienvenido al menu principal de la seccion de Comprobantes.\n\n" +

                "Para generar el comprobante de sus compras por favor añada a la URI /crear"
                + " e ingrese su id de cliente y el numero de comprobante que eligio al momento de cada compra";
    }

    @GetMapping("/all")
    public List<Venta_Comprobante> buscarTodos () throws Exception{
        if (comprobanteServices.buscarTodos().size() != 0) { //Se
            return comprobanteServices.buscarTodos();
        } else throw new CustomException("¡No hay ningun comprobante registrado!");
    };

    @GetMapping("/id_comprobante/{id_comprobante}")
    public Venta_Comprobante buscarPorID (@PathVariable int id_comprobante) throws Exception{
        if (comprobanteServices.buscarPorId(id_comprobante)!= null) {
            return comprobanteServices.buscarPorId(id_comprobante);
        } else throw new CustomException("No hay ningun comprobante registrado con ese Id");
    }

    @PostMapping("/crear")
    public ComprobanteResponse crear (@RequestBody ComprobanteRequest request) throws Exception {
        return comprobanteServices.crear(request);
    }
}
