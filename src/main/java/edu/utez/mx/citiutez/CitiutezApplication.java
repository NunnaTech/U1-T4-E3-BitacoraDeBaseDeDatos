package edu.utez.mx.citiutez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class CitiutezApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiutezApplication.class, args);
	}

}
