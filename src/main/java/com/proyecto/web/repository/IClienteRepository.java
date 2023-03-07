package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.modelo.Cliente;

public interface IClienteRepository {
	
	public void insertar(Cliente cliente);
	
	public void actualizar(Cliente cliente);
	
	public Cliente buscarPorCedula(String cedula);

	List<Cliente> buscarPagosClientes();
	

}
