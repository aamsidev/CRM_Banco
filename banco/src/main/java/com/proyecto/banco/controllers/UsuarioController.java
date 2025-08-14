package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Usuarios;
import com.proyecto.banco.services.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuariosService usuarioService;

    // Crear un nuevo usuario
    @PostMapping
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuarios> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerPorId(@PathVariable int id) {
        Optional<Usuarios> usuario = usuarioService.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizar(@PathVariable int id, @RequestBody Usuarios actualizado) {
        try {
            Usuarios usuario = usuarioService.actualizarUsuario(id, actualizado);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
