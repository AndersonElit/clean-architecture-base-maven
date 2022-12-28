package com.cleanarchitecture.controllers;

import com.cleanarchitecture.services.ExampleService;
import com.cleanarchitecturebase.producto.model.Producto;
import com.cleanarchitecturebase.utils.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/api-clean-architecture")
@AllArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/ejemplo-saludo")
    public String saludar() {
        return "Hola desde clean architecture.";
    }

    @GetMapping("/lista")
    public ResponseEntity<Response<Object>> listaProductos() {
        Response<Object> response = Response.builder().build();
        try {
            List<Producto> listaProductos = exampleService.listarProductos();
            response.setResponse(listaProductos);
            response.setCodigo(HttpStatus.OK.toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
