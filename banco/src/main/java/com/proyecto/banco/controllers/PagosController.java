package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Pagos;
import com.proyecto.banco.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private PagosService pagosService;

    // Crear un nuevo pago
    @PostMapping
    public ResponseEntity<Pagos> crearPago(@RequestBody Pagos pago) {
        Pagos nuevoPago = pagosService.crearPago(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    // Listar todos los pagos
    @GetMapping
    public ResponseEntity<List<Pagos>> obtenerTodos() {
        return ResponseEntity.ok(pagosService.obtenerTodos());
    }

    // Obtener pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagos> obtenerPorId(@PathVariable int id) {
        return pagosService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un pago
    @PutMapping("/{id}")
    public ResponseEntity<Pagos> actualizarPago(@PathVariable int id, @RequestBody Pagos pagoActualizado) {
        try {
            Pagos pago = pagosService.actualizarPago(id, pagoActualizado);
            return ResponseEntity.ok(pago);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable int id) {
        pagosService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
