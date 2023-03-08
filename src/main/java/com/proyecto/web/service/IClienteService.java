package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

public interface IClienteService {

	boolean registrar(ClienteTO cliente);

	boolean actualizar(ClienteActualizarTO cliente);

	ClienteActualizarTO encontrarPorCedula(String cedula);

	void actualizar(ClienteTO cliente);

	ClienteActualizarTO buscar(Integer id);

	void borrar(Integer id);

	List<ClienteActualizarTO> buscarPorApellido(String apellido);

	Cliente buscarPorCedulaCliente(String cedula);

}
