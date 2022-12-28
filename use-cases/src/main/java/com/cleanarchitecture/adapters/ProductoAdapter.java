package com.cleanarchitecture.adapters;

import com.cleanarchitecture.ports.ProductoPort;
import com.cleanarchitecturebase.producto.model.Producto;
import com.cleanarchitecturebase.producto.repository.ProductoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductoAdapter implements ProductoPort {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.listarProductos();
    }

}
