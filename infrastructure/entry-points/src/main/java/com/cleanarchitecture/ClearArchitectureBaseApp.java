package com.cleanarchitecture;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPI30
public class ClearArchitectureBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(ClearArchitectureBaseApp.class, args);
    }

}
