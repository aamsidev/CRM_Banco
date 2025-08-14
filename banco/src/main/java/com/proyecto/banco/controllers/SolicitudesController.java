package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Solicitudes;
import com.proyecto.banco.services.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "http://localhost:4200") // Permite peticiones desde Angular
public class SolicitudesController {

    @Autowired
    private SolicitudesService solicitudesService;

    // Crear solicitud
    @PostMapping
    public Solicitudes crearSolicitud(@RequestBody Solicitudes solicitud) {
        return solicitudesService.crearSolicitud(solicitud);
    }

    // Listar todas
    @GetMapping
    public List<Solicitudes> obtenerTodas() {
        return solicitudesService.obtenerTodas();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Solicitudes obtenerPorId(@PathVariable int id) {
        return solicitudesService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID " + id));
    }

    // Actualizar
    @PutMapping("/{id}")
    public Solicitudes actualizarSolicitud(@PathVariable int id, @RequestBody Solicitudes solicitudActualizada) {
        return solicitudesService.actualizarSolicitud(id, solicitudActualizada);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable int id) {
        solicitudesService.eliminarSolicitud(id);
    }
}
