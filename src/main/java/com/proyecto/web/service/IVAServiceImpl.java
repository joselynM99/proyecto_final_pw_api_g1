package com.proyecto.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.IVA;
import com.proyecto.web.repository.IIVARepo;

@Service
public class IVAServiceImpl implements IIVAService {

	@Autowired
	private IIVARepo iIVARepo;
	
	@Override
	public void insertar(IVA iva) {
		// TODO Auto-generated method stub
		this.iIVARepo.insertar(iva);
	}

	@Override
	public void actualizar(IVA iva) {
		// TODO Auto-generated method stub
		this.iIVARepo.actualizar(iva);
	}

	@Override
	public IVA buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iIVARepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iIVARepo.borrar(id);
	}

}
