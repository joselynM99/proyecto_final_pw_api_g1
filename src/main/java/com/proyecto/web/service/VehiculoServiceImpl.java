package com.proyecto.web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Vehiculo;
import com.proyecto.web.repository.IVehiculoRepo;

import jakarta.transaction.Transactional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo iVehiculoRepo;
	
	@Override
	@Transactional
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.insertar(vehiculo);
	}

	@Override
	@Transactional
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscar(id);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.borrar(id);
	}

}
