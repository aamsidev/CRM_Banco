package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Contratos;

public interface IContratosRepository extends JpaRepository<Contratos, Integer> {

}
