package com.proyecto.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.repository.IClienteRepo;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo iClienteRepo;
	
	
	@Override
	@Transactional
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepo.insertar(cliente);
	}

	@Override
	@Transactional
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iClienteRepo.buscar(id);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iClienteRepo.borrar(id);
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iClienteRepo.buscarPorApellido(apellido);
	}

	@Override
	public void borrarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		this.iClienteRepo.borrarPorApellido(apellido);
	}

}
