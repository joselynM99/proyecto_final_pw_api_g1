package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.repository.model.Cliente;

public interface IClienteRepo {

	// CRUD
	boolean insertar(Cliente cliente);

	boolean actualizar(Cliente cliente);

	Cliente buscar(Integer id);

	void borrar(Integer id);

	// Otro

	List<Cliente> buscarPorApellido(String apellido);

	void borrarPorApellido(String apellido);

	Cliente buscarPorCedula(String cedula);

	List<Cliente> buscarPagosClientes();
}
