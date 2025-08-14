package com.proyecto.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.banco.models.Productos;
import com.proyecto.banco.repositories.IProductosRepository;

@Service
public class ProductoService {

    @Autowired
    private IProductosRepository productoRepo;

    // Crear un nuevo producto
    public Productos crearProducto(Productos producto) {
        return productoRepo.save(producto);
    }

    // Obtener todos los productos
    public List<Productos> obtenerTodos() {
        return productoRepo.findAll();
    }

    // Obtener un producto por ID
    public Optional<Productos> obtenerPorId(int id) {
        return productoRepo.findById(id);
    }

    // Actualizar un producto existente
    public Productos actualizarProducto(int id, Productos productoActualizado) {
        return productoRepo.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setTipo(productoActualizado.getTipo());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setTasaInteres(productoActualizado.getTasaInteres());
            // No se actualiza fechaCreacion porque suele ser fija
            return productoRepo.save(producto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID " + id));
    }

    // Eliminar producto por ID
    public void eliminarProducto(int id) {
        productoRepo.deleteById(id);
    }
}
