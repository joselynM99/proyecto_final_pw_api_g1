package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IClienteService;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

@RestController
@RequestMapping(path = "/clientes")
@CrossOrigin
public class ClienteControllerRestFul {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registrarCliente(@RequestBody ClienteTO cliente) {
		this.clienteService.registrar(cliente);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody ClienteActualizarTO cliente) {
		cliente.setId(id);
		this.clienteService.actualizar(cliente);
	}
	
	

}
