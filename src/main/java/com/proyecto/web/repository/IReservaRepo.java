package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.modelo.Reserva;

public interface IReservaRepo {

	// CRUD
	void insertar(Reserva reserva);

	void actualizar(Reserva reserva);

	Reserva buscar(Integer id);

	void borrar(Integer id);
	
	// Otros
	
	List<Reserva> reporteReserva();

}
