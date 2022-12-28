package com.cleanarchitecture.services;

import com.cleanarchitecture.ports.ProductoPort;
import com.cleanarchitecturebase.producto.model.Producto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExampleService {

    private final ProductoPort productoPort;

    public List<Producto> listarProductos() {
        return productoPort.listarProductos();
    }

}
