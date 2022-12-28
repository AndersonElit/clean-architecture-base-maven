package com.cleanarchitecture.ports;

import com.cleanarchitecturebase.producto.model.Producto;

import java.util.List;

public interface ProductoPort {
    List<Producto> listarProductos();
}
