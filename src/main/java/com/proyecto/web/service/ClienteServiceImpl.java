package com.proyecto.web.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
	
	private static final Logger LOG = Logger.getRootLogger();

	@Override
	public void registrar(ClienteTO cliente) {
		LOG.info("Insertando cliente: " + cliente.getCedula());
		 this.clienteRepository.insertar(this.convertirClienteTOACliente(cliente));
	}

	@Override
	public void actualizar(ClienteActualizarTO cliente) {
		LOG.info("Actualizar cliente: " +cliente.getId());
		 this.clienteRepository.actualizar(this.convertirClienteActualizarTOACliente(cliente));
	}

	@Override
	public ClienteActualizarTO encontrarPorCedula(String cedula) {

		if (this.clienteRepository.buscarPorCedula(cedula) == null) {
			LOG.info("No se encontró cliente con cedula: " +cedula);
			return null;
		} else {
			LOG.info("Cliente encontrado");
			return this.convertirClienteAClienteActualizarTO(this.clienteRepository.buscarPorCedula(cedula));
		}

	}

	@Override
	public Cliente buscarPorCedulaParaReserva(String cedula) {
		LOG.info("Buscando Cliente ");
		return this.clienteRepository.buscarPorCedulaParaReserva(cedula);
	}

	@Override
	public void actualizar(ClienteTO cliente) {
		LOG.info("Actualizar cliente: " +cliente.getApellido());
		Cliente aux=convertirClienteTOACliente(cliente);
		this.clienteRepository.actualizar(aux);
	}

	@Override
	public ClienteActualizarTO buscar(Integer id) {
		LOG.info("Buscando Cliente ");
		Cliente cliente=this.clienteRepository.buscar(id);
		ClienteActualizarTO aux=convertirClienteAClienteActualizarTO(cliente);
		return aux;
	}

	@Override
	public void borrar(Integer id) {
		LOG.info("Borrando Cliente " +id);
		this.clienteRepository.borrar(id);
	}

	@Override
	public List<ClienteActualizarTO> buscarPorApellido(String apellido) {
		LOG.info("Borrando Cliente " +apellido);
		List<Cliente> lista=this.clienteRepository.buscarPorApellido(apellido);
		List<ClienteActualizarTO> listaDos=new ArrayList<>();
		for(Cliente aux: lista) {
			LOG.info("Convirtiando Cliente" );
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
