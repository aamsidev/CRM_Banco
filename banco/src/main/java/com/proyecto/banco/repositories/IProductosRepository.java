package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.banco.models.Productos;

public interface IProductosRepository extends JpaRepository<Productos, Integer> {

}
