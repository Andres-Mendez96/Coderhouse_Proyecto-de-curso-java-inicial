package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLIENTES")
public class Clientes {

    // Declaro las variables que seran las columnas de la tabla clientes
    @Column (name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column (name = "DNI")
    private Integer dni;

    @Id
    @Column (name = "ID_CLIENTE")
    private Integer id_cliente;

    //Declaro los constructores


    public Clientes() {
    }

    public Clientes(String nombre, String apellido, Integer dni, Integer id_cliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id_cliente = id_cliente;
    }

    // Creo los Getters y Setters de las variables de instancia.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
}
