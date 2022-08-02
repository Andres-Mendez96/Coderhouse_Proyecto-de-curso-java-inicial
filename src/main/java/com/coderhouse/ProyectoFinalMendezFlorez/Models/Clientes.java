package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLIENTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
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



}
