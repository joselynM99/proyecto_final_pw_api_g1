package com.proyecto.web.service;

import java.util.List;

import org.apache.log4j.Logger;
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

	private static final Logger LOG = Logger.getRootLogger();

	@Override
	public void ingresarVehiculo(VehiculoTO vehiculo) {
		VehiculoTO vehiculo1 = vehiculo;
		vehiculo1.setEstado("D");
		LOG.info("Ingresando vehiculo: " + vehiculo1.getPlaca());
		this.iVehiculoService.insertar(vehiculo1);

	}

	@Override
	public List<ClienteActualizarTO> buscarPorApellido(String apellido) {
		return this.iClienteService.buscarPorApellido(apellido);
	}

	@Override
	public void actualizarCliente(ClienteActualizarTO cliente) {
		this.iClienteService.actualizar(cliente);
	}

	@Override
	public void eliminarClienteId(Integer id) {
		this.iClienteService.borrar(id);
	}

	@Override
	public ClienteActualizarTO buscarPorId(Integer id) {
		LOG.info("Buscando cliente por id: " + id);
		return this.iClienteService.buscar(id);
	}

}
