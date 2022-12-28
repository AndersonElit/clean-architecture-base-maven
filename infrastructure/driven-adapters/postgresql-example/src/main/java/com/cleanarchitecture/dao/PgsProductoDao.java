package com.cleanarchitecture.dao;

import com.cleanarchitecture.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgsProductoDao extends JpaRepository<ProductoEntity, Integer> {

}
