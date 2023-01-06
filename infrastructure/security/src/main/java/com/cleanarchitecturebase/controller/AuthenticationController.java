package com.cleanarchitecturebase.controller;

import com.cleanarchitecturebase.model.request.AuthenticationRequest;
import com.cleanarchitecturebase.model.request.UsuarioRequest;
import com.cleanarchitecturebase.model.response.AuthenticationResponse;
import com.cleanarchitecturebase.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/registrar-usuario")
    public ResponseEntity registrarUsuario(
            @RequestBody UsuarioRequest request
            ) {
        try {
            this.authenticationService.registrarUsuario(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity<AuthenticationResponse> autenticar(
            @RequestBody AuthenticationRequest request
    ) {
        try {
            var response = authenticationService.autenticar(request);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
