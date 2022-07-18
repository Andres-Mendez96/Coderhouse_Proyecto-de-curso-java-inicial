package com.coderhouse.ProyectoFinalMendezFlorez.Repositories;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Productos, Integer> {
}
