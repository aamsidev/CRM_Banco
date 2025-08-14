package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Kpis;
import com.proyecto.banco.services.KpisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kpis")
@CrossOrigin(origins = "http://localhost:4200") // Permite peticiones desde Angular
public class KpisController {

    @Autowired
    private KpisService kpisService;

    // Crear KPI
    @PostMapping
    public ResponseEntity<Kpis> crearKpi(@RequestBody Kpis kpi) {
        return ResponseEntity.ok(kpisService.crearKpi(kpi));
    }

    // Obtener todos los KPIs
    @GetMapping
    public ResponseEntity<List<Kpis>> obtenerTodos() {
        return ResponseEntity.ok(kpisService.obtenerTodos());
    }

    // Obtener KPI por ID
    @GetMapping("/{id}")
    public ResponseEntity<Kpis> obtenerPorId(@PathVariable int id) {
        return kpisService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar KPI
    @PutMapping("/{id}")
    public ResponseEntity<Kpis> actualizarKpi(@PathVariable int id, @RequestBody Kpis kpi) {
        try {
            return ResponseEntity.ok(kpisService.actualizarKpi(id, kpi));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar KPI
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarKpi(@PathVariable int id) {
        kpisService.eliminarKpi(id);
        return ResponseEntity.noContent().build();
    }
}
