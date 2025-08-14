package com.proyecto.banco.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.banco.models.Productos;
import com.proyecto.banco.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200") // Para permitir peticiones desde Angular
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Crear producto
    @PostMapping
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos producto) {
        Productos nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Productos>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtenerPorId(@PathVariable int id) {
        Optional<Productos> producto = productoService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable int id, @RequestBody Productos producto) {
        try {
            return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
