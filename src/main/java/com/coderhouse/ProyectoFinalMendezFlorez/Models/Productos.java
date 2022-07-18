package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Productos {

    //Declaro las variables que seran las columnas en la tabla Productos
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombre_producto;

    @Id
    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Long precio;

    @Column(name = "STOCK_DISPONIBLE")
    private Integer stock_disponible;

    // Declaro los constructores

    public Productos() {
    }

    public Productos(String nombre_producto, Integer codigo, String descripcion, Long precio, Integer stock_disponible) {
        this.nombre_producto = nombre_producto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock_disponible = stock_disponible;
    }

    // Metodos getter y setter

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Integer getStock_disponible() {
        return stock_disponible;
    }

    public void setStock_disponible(Integer stock_disponible) {
        this.stock_disponible = stock_disponible;
    }
}
