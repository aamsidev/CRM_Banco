package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Kpis;

public interface IKpisRepository extends JpaRepository<Kpis, Integer> {

}
