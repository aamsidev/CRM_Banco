package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Pagos;

public interface IPagosRepository extends JpaRepository<Pagos, Integer> {

}
