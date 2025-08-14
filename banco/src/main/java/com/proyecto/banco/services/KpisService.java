package com.proyecto.banco.services;

import com.proyecto.banco.models.Kpis;
import com.proyecto.banco.repositories.IKpisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KpisService {

    @Autowired
    private IKpisRepository kpisRepo;

    public Kpis crearKpi(Kpis kpi) {
        return kpisRepo.save(kpi);
    }

    public List<Kpis> obtenerTodos() {
        return kpisRepo.findAll();
    }

    public Optional<Kpis> obtenerPorId(int id) {
        return kpisRepo.findById(id);
    }

    public Kpis actualizarKpi(int id, Kpis kpiActualizado) {
        return kpisRepo.findById(id).map(kpi -> {
            kpi.setNombre(kpiActualizado.getNombre());
            kpi.setValor(kpiActualizado.getValor());
            kpi.setPeriodo(kpiActualizado.getPeriodo());
            kpi.setDescripcion(kpiActualizado.getDescripcion());
            kpi.setEstado(kpiActualizado.getEstado());
            return kpisRepo.save(kpi);
        }).orElseThrow(() -> new RuntimeException("KPI no encontrado con ID " + id));
    }

    public void eliminarKpi(int id) {
        kpisRepo.deleteById(id);
    }
}
