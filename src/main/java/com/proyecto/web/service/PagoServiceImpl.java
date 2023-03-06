package com.proyecto.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Pago;
import com.proyecto.web.repository.IPagoRepo;

@Service
public class PagoServiceImpl implements IPagoService {

	@Autowired
	private IPagoRepo iPagoRepo;
	
	@Override
	public void insertar(Pago pago) {
		// TODO Auto-generated method stub
		this.iPagoRepo.insertar(pago);
	}

	@Override
	public void actualizar(Pago pago) {
		// TODO Auto-generated method stub
		this.iPagoRepo.actualizar(pago);
	}

	@Override
	public Pago buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPagoRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iPagoRepo.borrar(id);
	}

}
