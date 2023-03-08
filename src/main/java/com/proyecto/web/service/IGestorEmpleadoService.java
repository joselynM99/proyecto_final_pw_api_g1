package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.VehiculoTO;

public interface IGestorEmpleadoService {

	public void ingresarVehiculo(VehiculoTO vehiculo);

	public List<ClienteActualizarTO> buscarPorApellido(String apellido);

	public void actualizarCliente(ClienteActualizarTO cliente);

	public void eliminarClienteId(Integer id);

	public ClienteActualizarTO buscarPorId(Integer id);
}
