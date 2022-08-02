package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

    //Declaro las variables que seran las columnas en la tabla Productos

    @Id
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "STOCK_DISPONIBLE")
    private Integer stock_disponible;




}
