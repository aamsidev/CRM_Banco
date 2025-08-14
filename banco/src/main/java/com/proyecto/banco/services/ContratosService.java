package com.proyecto.banco.services;

import com.proyecto.banco.models.Contratos;
import com.proyecto.banco.repositories.IContratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratosService {

    @Autowired
    private IContratosRepository contratosRepo;

    public Contratos crearContrato(Contratos contrato) {
        return contratosRepo.save(contrato);
    }

    public List<Contratos> obtenerTodos() {
        return contratosRepo.findAll();
    }

    public Optional<Contratos> obtenerPorId(int id) {
        return contratosRepo.findById(id);
    }

    public Contratos actualizarContrato(int id, Contratos contratoActualizado) {
        return contratosRepo.findById(id).map(contrato -> {
            contrato.setSolicitud(contratoActualizado.getSolicitud());
            contrato.setFechaInicio(contratoActualizado.getFechaInicio());
            contrato.setFechaFin(contratoActualizado.getFechaFin());
            contrato.setMonto(contratoActualizado.getMonto());
            contrato.setEstado(contratoActualizado.getEstado());
            return contratosRepo.save(contrato);
        }).orElseThrow(() -> new RuntimeException("Contrato no encontrado con ID " + id));
    }

    public void eliminarContrato(int id) {
        contratosRepo.deleteById(id);
    }
}
