package com.proyecto.web.service;

import com.proyecto.web.repository.model.Pago;

public interface IPagoService {

	// CRUD
	void insertar(Pago pago);

	void actualizar(Pago pago);

	Pago buscar(Integer id);

	void borrar(Integer id);
}
