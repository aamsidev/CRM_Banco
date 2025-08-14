package com.proyecto.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.banco.dtos.AutenticacionFilter;
import com.proyecto.banco.models.Usuarios;
import com.proyecto.banco.repositories.IUsuariosRepository;

@Service
public class AutenticacionService {
	
	@Autowired
	private IUsuariosRepository usuarioRepo;
	
	public Usuarios autenticar(AutenticacionFilter filter) {
	    System.out.println("Buscando usuario con correo: " + filter.getCorreo());
	    System.out.println("Y contraseña: " + filter.getPassword());
	    
	    Usuarios usuario = usuarioRepo.findByCorreoAndPassword(filter.getCorreo(), filter.getPassword());
	    
	    if (usuario != null) {
	        System.out.println("Usuario encontrado: " + usuario.getCorreo());
	    } else {
	        System.out.println("Usuario no encontrado con esas credenciales.");
	    }

	    if (usuario != null && usuario.getEstado() == Usuarios.Estado.activo) {
	        return usuario;
	    }

	    return null;
	}

}

