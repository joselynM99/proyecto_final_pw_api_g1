package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.modelo.Vehiculo;

public interface IGestorEmpleadoService {

	public void ingresarVehiculo(Vehiculo vehiculo);
	
	public List<Cliente> buscarPorApellido(String apellido);
	
	public void actualizarCliente(Cliente cliente);
	
	public void eliminarCliente(Cliente cliente);
	
}