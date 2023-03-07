package com.proyecto.web.service;

import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

public interface IClienteService {
	
	public void registrar(ClienteTO cliente);
	
	public void actualizar(ClienteActualizarTO cliente);

	ClienteActualizarTO encontrarPorCedula(String cedula);

}
