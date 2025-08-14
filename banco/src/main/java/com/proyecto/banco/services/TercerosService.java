package com.proyecto.banco.services;

import com.proyecto.banco.models.Terceros;
import com.proyecto.banco.repositories.ITercerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TercerosService {

    @Autowired
    private ITercerosRepository tercerosRepo;

    public Terceros crearTercero(Terceros tercero) {
        return tercerosRepo.save(tercero);
    }

    public List<Terceros> obtenerTodos() {
        return tercerosRepo.findAll();
    }

    public Optional<Terceros> obtenerPorId(int id) {
        return tercerosRepo.findById(id);
    }

    public Terceros actualizarTercero(int id, Terceros terceroActualizado) {
        return tercerosRepo.findById(id).map(tercero -> {
            tercero.setTipo(terceroActualizado.getTipo());
            tercero.setNombre(terceroActualizado.getNombre());
            tercero.setDocumentoTipo(terceroActualizado.getDocumentoTipo());
            tercero.setDocumentoNumero(terceroActualizado.getDocumentoNumero());
            tercero.setTelefono(terceroActualizado.getTelefono());
            tercero.setCorreo(terceroActualizado.getCorreo());
            tercero.setDireccion(terceroActualizado.getDireccion());
            tercero.setEstado(terceroActualizado.getEstado());
            return tercerosRepo.save(tercero);
        }).orElseThrow(() -> new RuntimeException("Tercero no encontrado con ID " + id));
    }

    public void eliminarTercero(int id) {
        tercerosRepo.deleteById(id);
    }
}
