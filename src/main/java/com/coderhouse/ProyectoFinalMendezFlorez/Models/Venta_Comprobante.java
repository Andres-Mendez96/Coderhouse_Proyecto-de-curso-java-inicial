package com.coderhouse.ProyectoFinalMendezFlorez.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "VENTA_COMPROBANTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta_Comprobante {

    @Id
    @Column(name = "ID_COMPROBANTE")
    private Integer id_comprobante;

    @Column(name = "ID_CLIENTE")
    private Integer id_cliente;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombre_Completo;


    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "TOTAL")
    private Float total;

    /*
    @OneToMany(mappedBy = "venta_comprobante_fk")
    List<Linea_De_Venta> lineas_de_ventas;


    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    Clientes clientes; */
}
