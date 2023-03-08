package com.proyecto.web.service;

import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

public interface IClienteService {
	
	public void registrar(ClienteTO cliente);
	
	public void actualizar(ClienteActualizarTO cliente);

	public Cliente buscarPorCedula(String cedula);

}
