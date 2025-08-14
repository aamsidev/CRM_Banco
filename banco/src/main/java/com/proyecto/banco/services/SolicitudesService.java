package com.proyecto.banco.services;

import com.proyecto.banco.models.Solicitudes;
import com.proyecto.banco.repositories.ISolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudesService {

    @Autowired
    private ISolicitudesRepository solicitudesRepo;

    public Solicitudes crearSolicitud(Solicitudes solicitud) {
        return solicitudesRepo.save(solicitud);
    }

    public List<Solicitudes> obtenerTodas() {
        return solicitudesRepo.findAll();
    }

    public Optional<Solicitudes> obtenerPorId(int id) {
        return solicitudesRepo.findById(id);
    }

    public Solicitudes actualizarSolicitud(int id, Solicitudes solicitudActualizada) {
        return solicitudesRepo.findById(id).map(solicitud -> {
            solicitud.setTercero(solicitudActualizada.getTercero());
            solicitud.setProducto(solicitudActualizada.getProducto());
            solicitud.setEstadoSolicitud(solicitudActualizada.getEstadoSolicitud());
            solicitud.setFechaSolicitud(solicitudActualizada.getFechaSolicitud());
            solicitud.setFechaRespuesta(solicitudActualizada.getFechaRespuesta());
            solicitud.setObservaciones(solicitudActualizada.getObservaciones());
            solicitud.setEstado(solicitudActualizada.getEstado());
            return solicitudesRepo.save(solicitud);
        }).orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID " + id));
    }

    public void eliminarSolicitud(int id) {
        solicitudesRepo.deleteById(id);
    }
}
