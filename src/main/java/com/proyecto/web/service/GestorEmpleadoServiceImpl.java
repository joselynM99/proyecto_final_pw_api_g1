package com.proyecto.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.modelo.Vehiculo;

@Service
public class GestorEmpleadoServiceImpl implements IGestorEmpleadoService {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo1=vehiculo;
		vehiculo1.setEstado("D");
		this.iVehiculoService.insertar(vehiculo1);		
		
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iClienteService.buscarPorApellido(apellido);
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteService.actualizar(cliente);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		Integer id=cliente.getId();
		this.iClienteService.borrar(id);
	}

}
