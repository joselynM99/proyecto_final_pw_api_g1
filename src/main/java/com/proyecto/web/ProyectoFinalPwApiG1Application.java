package com.proyecto.web;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.service.IClienteService;

@SpringBootApplication
public class ProyectoFinalPwApiG1Application  {
	


	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPwApiG1Application.class, args);
	}


}
