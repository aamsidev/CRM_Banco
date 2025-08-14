package com.proyecto.banco.controllers;

import com.proyecto.banco.models.Cuentas;
import com.proyecto.banco.services.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "http://localhost:4200") // Permite peticiones desde Angular
public class CuentasController {

    @Autowired
    private CuentasService cuentasService;

    // Crear cuenta
    @PostMapping
    public Cuentas crearCuenta(@RequestBody Cuentas cuenta) {
        return cuentasService.crearCuenta(cuenta);
    }

    // Listar todas las cuentas
    @GetMapping
    public List<Cuentas> obtenerTodas() {
        return cuentasService.obtenerTodas();
    }

    // Obtener una cuenta por ID
    @GetMapping("/{id}")
    public Optional<Cuentas> obtenerPorId(@PathVariable int id) {
        return cuentasService.obtenerPorId(id);
    }

    // Actualizar una cuenta
    @PutMapping("/{id}")
    public Cuentas actualizarCuenta(@PathVariable int id, @RequestBody Cuentas cuenta) {
        return cuentasService.actualizarCuenta(id, cuenta);
    }

    // Eliminar una cuenta
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable int id) {
        cuentasService.eliminarCuenta(id);
    }
}
