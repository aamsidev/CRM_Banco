package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Solicitudes;

public interface ISolicitudesRepository extends JpaRepository<Solicitudes, Integer> {

}
