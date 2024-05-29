package com.example.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.personapi")
public class PersonApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonApiApplication.class, args);
	/** linea agregada de prueba **/
	/** se añade una nueva linea de codigo **/
	/** esto solo son pruebas **/
    }
}
