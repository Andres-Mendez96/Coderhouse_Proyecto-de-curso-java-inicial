package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Linea_De_Venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Linea_De_Venta {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENTA")
    private int id_venta;

    @Column(name = "CODIGO")
    private Integer codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "ID_COMPROBANTE")
    private Integer id_comprobante;



   /*
    @ManyToOne
    @JoinColumn(name = "ID_COMPROBANTE")
    Venta_Comprobante venta_comprobante_fk;


    @ManyToOne
    @JoinColumn(name = "CODIGO")
    Productos productos_fk; */
}
