package com.proyecto.web.service;

import java.util.ArrayList;
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
	public void registrar(ClienteTO cliente) {
		this.clienteRepository.insertar(this.convertirClienteTOACliente(cliente));
	}

	@Override
	public void actualizar(ClienteActualizarTO cliente) {
		this.clienteRepository.actualizar(this.convertirClienteActualizarTOACliente(cliente));
		
	}
	@Override
	public ClienteActualizarTO encontrarPorCedula(String cedula) {
		
		if(this.clienteRepository.buscarPorCedula(cedula)==null) {
			return null;
		}else {
			return this.convertirClienteAClienteActualizarTO(this.clienteRepository.buscarPorCedula(cedula));
		}
		
	} 
	
	@Override
	public Cliente buscarPorCedulaCliente(String cedula) {
		return this.clienteRepository.buscarPorCedula(cedula);
	}
	
	
	

	@Override
	public void actualizar(ClienteTO cliente) {
		Cliente aux=convertirClienteTOACliente(cliente);
		this.clienteRepository.actualizar(aux);
	}

	@Override
	public ClienteActualizarTO buscar(Integer id) {
		
		Cliente cliente=this.clienteRepository.buscar(id);
		ClienteActualizarTO aux=convertirClienteAClienteActualizarTO(cliente);
		return aux;
	}

	@Override
	public void borrar(Integer id) {
		this.clienteRepository.borrar(id);
	}

	@Override
	public List<ClienteActualizarTO> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		List<Cliente> lista=this.clienteRepository.buscarPorApellido(apellido);
		List<ClienteActualizarTO> listaDos=new ArrayList<>();
		for(Cliente aux: lista) {
			ClienteActualizarTO aux2=convertirClienteAClienteActualizarTO(aux);
			listaDos.add(aux2);
		}
		
		return listaDos;
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
