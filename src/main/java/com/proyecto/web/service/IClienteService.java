package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

public interface IClienteService {

	void registrar(ClienteTO cliente);

	void actualizar(ClienteActualizarTO cliente);

	ClienteActualizarTO encontrarPorCedula(String cedula);

	void actualizar(Cliente cliente);

	Cliente buscar(Integer id);

	void borrar(Integer id);

	List<Cliente> buscarPorApellido(String apellido);

	// CRUD
	
}
