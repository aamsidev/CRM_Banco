package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Terceros;
import com.proyecto.banco.services.TercerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terceros")
@CrossOrigin(origins = "*") // Permite peticiones desde Angular
public class TercerosController {

    @Autowired
    private TercerosService tercerosService;

    // Crear un tercero
    @PostMapping
    public ResponseEntity<Terceros> crearTercero(@RequestBody Terceros tercero) {
        return ResponseEntity.ok(tercerosService.crearTercero(tercero));
    }

    // Obtener todos los terceros
    @GetMapping
    public ResponseEntity<List<Terceros>> obtenerTodos() {
        return ResponseEntity.ok(tercerosService.obtenerTodos());
    }

    // Obtener un tercero por ID
    @GetMapping("/{id}")
    public ResponseEntity<Terceros> obtenerPorId(@PathVariable int id) {
        return tercerosService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un tercero
    @PutMapping("/{id}")
    public ResponseEntity<Terceros> actualizarTercero(
            @PathVariable int id,
            @RequestBody Terceros tercero) {
        try {
            return ResponseEntity.ok(tercerosService.actualizarTercero(id, tercero));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un tercero
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTercero(@PathVariable int id) {
        tercerosService.eliminarTercero(id);
        return ResponseEntity.noContent().build();
    }
}
