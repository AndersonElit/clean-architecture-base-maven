package com.cleanarchitecturebase.app.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("${spring.application.component}")
public class ClearArchitectureBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(ClearArchitectureBaseApp.class, args);
    }

}
