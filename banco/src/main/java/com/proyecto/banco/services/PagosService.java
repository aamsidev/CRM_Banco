package com.proyecto.banco.services;

import com.proyecto.banco.models.Pagos;
import com.proyecto.banco.repositories.IPagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService {

    @Autowired
    private IPagosRepository pagosRepo;

    public Pagos crearPago(Pagos pago) {
        return pagosRepo.save(pago);
    }

    public List<Pagos> obtenerTodos() {
        return pagosRepo.findAll();
    }

    public Optional<Pagos> obtenerPorId(int id) {
        return pagosRepo.findById(id);
    }

    public Pagos actualizarPago(int id, Pagos pagoActualizado) {
        return pagosRepo.findById(id).map(pago -> {
            pago.setContrato(pagoActualizado.getContrato());
            pago.setFechaPago(pagoActualizado.getFechaPago());
            pago.setMonto(pagoActualizado.getMonto());
            pago.setMetodoPago(pagoActualizado.getMetodoPago());
            pago.setEstado(pagoActualizado.getEstado());
            return pagosRepo.save(pago);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado con ID " + id));
    }

    public void eliminarPago(int id) {
        pagosRepo.deleteById(id);
    }
}
