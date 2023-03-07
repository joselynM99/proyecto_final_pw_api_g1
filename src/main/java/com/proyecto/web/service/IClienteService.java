package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.repository.model.Cliente;

public interface IClienteService {

	// CRUD
	void insertar(Cliente cliente);

	void actualizar(Cliente cliente);

	Cliente buscar(Integer id);

	void borrar(Integer id);

	List<Cliente> buscarPorApellido(String apellido);

	void borrarPorApellido(String apellido);
}
