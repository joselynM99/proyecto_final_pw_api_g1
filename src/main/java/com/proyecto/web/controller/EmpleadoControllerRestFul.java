package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IClienteService;
import com.proyecto.web.service.to.ClienteTO;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
public class EmpleadoControllerRestFul {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registrarCliente(@RequestBody ClienteTO cliente) {
		this.clienteService.registrar(cliente);
	}
}
