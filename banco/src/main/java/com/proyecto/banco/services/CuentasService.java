package com.proyecto.banco.services;

import com.proyecto.banco.models.Cuentas;
import com.proyecto.banco.repositories.ICuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentasService {

    @Autowired
    private ICuentasRepository cuentasRepo;

    public Cuentas crearCuenta(Cuentas cuenta) {
        return cuentasRepo.save(cuenta);
    }

    public List<Cuentas> obtenerTodas() {
        return cuentasRepo.findAll();
    }

    public Optional<Cuentas> obtenerPorId(int id) {
        return cuentasRepo.findById(id);
    }

    public Cuentas actualizarCuenta(int id, Cuentas cuentaActualizada) {
        return cuentasRepo.findById(id).map(cuenta -> {
            cuenta.setTercero(cuentaActualizada.getTercero());
            cuenta.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
            cuenta.setSaldo(cuentaActualizada.getSaldo());
            cuenta.setEstado(cuentaActualizada.getEstado());
            cuenta.setFechaApertura(cuentaActualizada.getFechaApertura());
            return cuentasRepo.save(cuenta);
        }).orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID " + id));
    }

    public void eliminarCuenta(int id) {
        cuentasRepo.deleteById(id);
    }
}
