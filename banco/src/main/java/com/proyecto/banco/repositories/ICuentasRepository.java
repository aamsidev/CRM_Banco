package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Cuentas;

public interface ICuentasRepository extends JpaRepository<Cuentas, Integer> {

}
