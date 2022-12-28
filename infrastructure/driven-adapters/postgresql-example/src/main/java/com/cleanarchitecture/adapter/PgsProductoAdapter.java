package com.cleanarchitecture.adapter;

import com.cleanarchitecture.dao.PgsProductoDao;
import com.cleanarchitecturebase.producto.model.Producto;
import com.cleanarchitecturebase.producto.repository.ProductoRepository;
import com.cleanarchitecturebase.utils.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PgsProductoAdapter implements ProductoRepository {

    private final PgsProductoDao pgsProductoDao;

    @Override
    public List<Producto> listarProductos() {
        return Mapper.mapAll(pgsProductoDao.findAll(), Producto.class);
    }

}
