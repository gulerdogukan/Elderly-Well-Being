package com.example.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.healthcare")

public class HealthcareAppApplication {

    

    public static void main(String[] args) {
        SpringApplication.run(HealthcareAppApplication.class, args);
    }
}