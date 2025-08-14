package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Contratos;
import com.proyecto.banco.services.ContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "http://localhost:4200") // Permite llamadas desde Angular
public class ContratosController {

    @Autowired
    private ContratosService contratosService;

    // Crear un contrato
    @PostMapping
    public Contratos crearContrato(@RequestBody Contratos contrato) {
        return contratosService.crearContrato(contrato);
    }

    // Listar todos
    @GetMapping
    public List<Contratos> obtenerTodos() {
        return contratosService.obtenerTodos();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Optional<Contratos> obtenerPorId(@PathVariable int id) {
        return contratosService.obtenerPorId(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Contratos actualizarContrato(@PathVariable int id, @RequestBody Contratos contrato) {
        return contratosService.actualizarContrato(id, contrato);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarContrato(@PathVariable int id) {
        contratosService.eliminarContrato(id);
    }
}
