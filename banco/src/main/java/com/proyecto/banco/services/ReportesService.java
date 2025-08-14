package com.proyecto.banco.services;

import com.proyecto.banco.models.Reportes;
import com.proyecto.banco.repositories.IReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportesService {

    @Autowired
    private IReportesRepository reportesRepo;

    public Reportes crearReporte(Reportes reporte) {
        return reportesRepo.save(reporte);
    }

    public List<Reportes> obtenerTodos() {
        return reportesRepo.findAll();
    }

    public Optional<Reportes> obtenerPorId(int id) {
        return reportesRepo.findById(id);
    }

    public Reportes actualizarReporte(int id, Reportes reporteActualizado) {
        return reportesRepo.findById(id).map(reporte -> {
            reporte.setTitulo(reporteActualizado.getTitulo());
            reporte.setDescripcion(reporteActualizado.getDescripcion());
            reporte.setTipo(reporteActualizado.getTipo());
            reporte.setRutaArchivo(reporteActualizado.getRutaArchivo());
            reporte.setGeneradoPor(reporteActualizado.getGeneradoPor());
            reporte.setEstado(reporteActualizado.getEstado());
            return reportesRepo.save(reporte);
        }).orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID " + id));
    }

    public void eliminarReporte(int id) {
        reportesRepo.deleteById(id);
    }
}
