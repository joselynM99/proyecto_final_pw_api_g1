package com.proyecto.web.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Reserva;
import com.proyecto.web.repository.IReservaRepo;

import jakarta.transaction.Transactional;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepo iReservaRepo;
	
	@Override
	@Transactional
	public void insertar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepo.insertar(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.iReservaRepo.actualizar(reserva);
	}

	@Override
	public Reserva buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iReservaRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iReservaRepo.borrar(id);
	}

	@Override
	public List<Reserva> reporteReserva() {
		// TODO Auto-generated method stub
		return this.iReservaRepo.reporteReserva();
	}



}
