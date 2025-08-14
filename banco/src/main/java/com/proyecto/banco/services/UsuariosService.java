package com.proyecto.banco.services;

import com.proyecto.banco.models.Usuarios;
import com.proyecto.banco.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepo;

    public Usuarios crearUsuario(Usuarios usuario) {
        return usuariosRepo.save(usuario);
    }

    public List<Usuarios> obtenerTodos() {
        return usuariosRepo.findAll();
    }

    public Optional<Usuarios> obtenerPorId(int id) {
        return usuariosRepo.findById(id);
    }

    public Usuarios actualizarUsuario(int id, Usuarios usuarioActualizado) {
        return usuariosRepo.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setEstado(usuarioActualizado.getEstado());
            return usuariosRepo.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + id));
    }

    public void eliminarUsuario(int id) {
        usuariosRepo.deleteById(id);
    }
}
