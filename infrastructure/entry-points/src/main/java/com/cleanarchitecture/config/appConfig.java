package com.cleanarchitecture.config;

import com.cleanarchitecture.adapters.ProductoAdapter;
import com.cleanarchitecture.ports.ProductoPort;
import com.cleanarchitecturebase.producto.repository.ProductoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {

    @Bean
    public ProductoPort productoPort(ProductoRepository productoRepository) {
        return new ProductoAdapter(productoRepository);
    }

}
