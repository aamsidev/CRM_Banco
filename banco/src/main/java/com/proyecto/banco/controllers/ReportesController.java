package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Reportes;
import com.proyecto.banco.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "http://localhost:4200") // Permitir Angular local
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    // Crear reporte
    @PostMapping
    public ResponseEntity<Reportes> crearReporte(@RequestBody Reportes reporte) {
        return ResponseEntity.ok(reportesService.crearReporte(reporte));
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<Reportes>> obtenerTodos() {
        return ResponseEntity.ok(reportesService.obtenerTodos());
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reportes> obtenerPorId(@PathVariable int id) {
        return reportesService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar reporte
    @PutMapping("/{id}")
    public ResponseEntity<Reportes> actualizarReporte(@PathVariable int id, @RequestBody Reportes reporte) {
        return ResponseEntity.ok(reportesService.actualizarReporte(id, reporte));
    }

    // Eliminar reporte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable int id) {
        reportesService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }
}
