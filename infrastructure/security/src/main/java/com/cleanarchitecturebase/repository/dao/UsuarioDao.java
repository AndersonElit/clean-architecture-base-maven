package com.cleanarchitecturebase.repository.dao;

import com.cleanarchitecturebase.repository.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);
}
