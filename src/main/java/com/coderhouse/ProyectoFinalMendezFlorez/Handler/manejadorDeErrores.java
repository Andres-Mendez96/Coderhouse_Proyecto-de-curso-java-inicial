package com.coderhouse.ProyectoFinalMendezFlorez.Handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class manejadorDeErrores {

    public String MensajeError;



    @ResponseBody
    @ExceptionHandler (CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String miMensajeError (CustomException ex){
        MensajeError  = ex.getMessage();
        return MensajeError;
    }

}
