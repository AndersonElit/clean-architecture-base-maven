package com.cleanarchitecture.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/api-clean-architecture")
public class ExampleController {

    @GetMapping("/ejemplo-saludo")
    public String saludar() {
        return "Hola desde clean architecture.";
    }

}
