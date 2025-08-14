package com.proyecto.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.banco.models.Usuarios;

public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {
	 Usuarios findByCorreoAndPassword(String correo, String password); 
}
