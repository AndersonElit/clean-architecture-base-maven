package com.cleanarchitecturebase.service;

import com.cleanarchitecturebase.model.enums.Rol;
import com.cleanarchitecturebase.model.request.AuthenticationRequest;
import com.cleanarchitecturebase.model.request.UsuarioRequest;
import com.cleanarchitecturebase.model.response.AuthenticationResponse;
import com.cleanarchitecturebase.repository.dao.UsuarioDao;
import com.cleanarchitecturebase.repository.entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioDao usuarioDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional(rollbackFor = { SQLException.class })
    public void registrarUsuario(UsuarioRequest request) {
        var usuario = UsuarioEntity.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correo(request.getCorreo())
                .nombreUsuario(request.getNombreUsuario())
                .clave(passwordEncoder.encode(request.getClave()))
                .rol(Rol.USER)
                .build();
        this.usuarioDao.save(usuario);
    }

    public AuthenticationResponse autenticar(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsuario(),
                        request.getClave()
                )
        );
        var usuario = usuarioDao.findByNombreUsuario(request.getUsuario())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
