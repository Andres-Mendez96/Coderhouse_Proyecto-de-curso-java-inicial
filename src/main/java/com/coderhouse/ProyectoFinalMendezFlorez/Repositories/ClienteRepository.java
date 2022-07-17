package com.coderhouse.ProyectoFinalMendezFlorez.Repositories;

import com.coderhouse.ProyectoFinalMendezFlorez.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Clientes, Integer> {
}
