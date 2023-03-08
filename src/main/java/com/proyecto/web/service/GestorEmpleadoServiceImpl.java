package com.proyecto.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.VehiculoTO;

@Service
public class GestorEmpleadoServiceImpl implements IGestorEmpleadoService {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Override
	public void ingresarVehiculo(VehiculoTO vehiculo) {
		// TODO Auto-generated method stub
		VehiculoTO vehiculo1=vehiculo;
		vehiculo1.setEstado("D");
		this.iVehiculoService.insertar(vehiculo1);		
		
	}

	@Override
	public List<ClienteActualizarTO> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iClienteService.buscarPorApellido(apellido);
	}

	@Override
	public void actualizarCliente(ClienteActualizarTO cliente) {
		// TODO Auto-generated method stub
		this.iClienteService.actualizar(cliente);
	}

	@Override
	public void eliminarClienteId(Integer id) {
		// TODO Auto-generated method stub
		this.iClienteService.borrar(id);
	}

	@Override
	public ClienteActualizarTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iClienteService.buscar(id);
	}

	

}
