package com.proyecto.web.service;

import com.proyecto.web.modelo.IVA;

public interface IIVAService {

	// CRUD
	void insertar(IVA iva);

	void actualizar(IVA iva);

	IVA buscar(Integer id);

	void borrar(Integer id);
}
