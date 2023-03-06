package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.modelo.Cliente;

public interface IClienteRepo {

	// CRUD
	void insertar(Cliente cliente);

	void actualizar(Cliente cliente);

	Cliente buscar(Integer id);

	void borrar(Integer id);

	// Otro

	List<Cliente> buscarPorApellido(String apellido);

	void borrarPorApellido(String apellido);
}
