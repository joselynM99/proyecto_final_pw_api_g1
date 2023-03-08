package com.proyecto.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IClienteRepo;
import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepository;

	@Override
	public boolean registrar(ClienteTO cliente) {
		return this.clienteRepository.insertar(this.convertirClienteTOACliente(cliente));

		
	}

	@Override
	public boolean actualizar(ClienteActualizarTO cliente) {
		return this.clienteRepository.actualizar(this.convertirClienteActualizarTOACliente(cliente));
		

	}

	@Override
	public ClienteActualizarTO encontrarPorCedula(String cedula) {

		if (this.clienteRepository.buscarPorCedula(cedula) == null) {
			return null;
		} else {
			return this.convertirClienteAClienteActualizarTO(this.clienteRepository.buscarPorCedula(cedula));
		}

	}

	@Override
	public Cliente buscarPorCedulaCliente(String cedula) {
		return this.clienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.clienteRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.clienteRepository.borrar(id);
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarPorApellido(apellido);
	}

	private ClienteTO convertirClienteAClienteTO(Cliente cliente) {
		ClienteTO c = new ClienteTO();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		return c;
	}

	private Cliente convertirClienteTOACliente(ClienteTO cliente) {
		Cliente c = new Cliente();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		return c;
	}

	private Cliente convertirClienteActualizarTOACliente(ClienteActualizarTO cliente) {
		Cliente c = new Cliente();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		c.setId(cliente.getId());
		return c;
	}

	private ClienteActualizarTO convertirClienteAClienteActualizarTO(Cliente cliente) {
		ClienteActualizarTO c = new ClienteActualizarTO();
		c.setApellido(cliente.getApellido());
		c.setCedula(cliente.getCedula());
		c.setFechaNacimiento(cliente.getFechaNacimiento());
		c.setGenero(cliente.getGenero());
		c.setNombre(cliente.getNombre());
		c.setTipoRegistro(cliente.getTipoRegistro());
		c.setId(cliente.getId());
		return c;
	}

}
