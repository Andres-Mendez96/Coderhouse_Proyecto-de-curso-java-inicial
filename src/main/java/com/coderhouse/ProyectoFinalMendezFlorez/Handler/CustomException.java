package com.coderhouse.ProyectoFinalMendezFlorez.Handler;

public class CustomException extends Exception{

    private String mensaje;

    public CustomException (String mensaje){
        super (mensaje);

    }
}
