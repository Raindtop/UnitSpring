package com.raindrop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.raindrop")
public class UnitSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitSpringApiApplication.class, args);
    }

}
