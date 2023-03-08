package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.repository.model.Vehiculo;

public interface IGestorEmpleadoService {

public void ingresarVehiculo(Vehiculo vehiculo);
	
	public List<Cliente> buscarPorApellido(String apellido);
	
	public void actualizarCliente(Cliente cliente);
		
	public void eliminarClienteId(Integer id);
	
	public Cliente buscarPorId(Integer id);
}
