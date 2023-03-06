package com.proyecto.web.repository;

import com.proyecto.web.modelo.Pago;

public interface IPagoRepo {

	// CRUD
	void insertar(Pago pago);

	void actualizar(Pago pago);

	Pago buscar(Integer id);

	void borrar(Integer id);

}
