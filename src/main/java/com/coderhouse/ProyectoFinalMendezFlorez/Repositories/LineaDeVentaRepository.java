package com.coderhouse.ProyectoFinalMendezFlorez.Repositories;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Linea_De_Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaDeVentaRepository extends JpaRepository<Linea_De_Venta, Integer> {
}
