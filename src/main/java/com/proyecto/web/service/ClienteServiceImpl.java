package com.proyecto.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyecto.web.repository.IClienteRepository;
import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void registrar(ClienteTO cliente) {
		this.clienteRepository.insertar(this.convertirClienteTOACliente(cliente));
	}

	@Override
	public void actualizar(ClienteActualizarTO cliente) {
		this.clienteRepository.actualizar(this.convertirClienteActualizarTOACliente(cliente));
		
	}
	
	
	private ClienteTO convertirClienteAClienteTO(Cliente cliente) {
		ClienteTO c = new ClienteTO();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento().toLocalDate());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		return c;
	}
	
	private Cliente convertirClienteTOACliente(ClienteTO cliente) {
		Cliente c = new Cliente();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento().atStartOfDay());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		return c;
	}
	
	private Cliente convertirClienteActualizarTOACliente(ClienteActualizarTO cliente) {
		Cliente c = new Cliente();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento().atStartOfDay());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		c.setId(cliente.getId());
		return c;
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return this.clienteRepository.buscarPorCedula(cedula);
	}


}
