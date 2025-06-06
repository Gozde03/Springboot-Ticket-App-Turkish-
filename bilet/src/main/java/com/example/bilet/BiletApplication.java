package com.example.bilet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@ComponentScan("com.example")  
public class BiletApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiletApplication.class, args);
    }
}
