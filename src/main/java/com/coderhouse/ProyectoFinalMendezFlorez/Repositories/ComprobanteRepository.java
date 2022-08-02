package com.coderhouse.ProyectoFinalMendezFlorez.Repositories;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Venta_Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<Venta_Comprobante,Integer> {
}
