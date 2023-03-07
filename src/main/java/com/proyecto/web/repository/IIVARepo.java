package com.proyecto.web.repository;

import com.proyecto.web.repository.model.IVA;

public interface IIVARepo {

	// CRUD
	void insertar(IVA iva);

	void actualizar(IVA iva);

	IVA buscar(Integer id);

	void borrar(Integer id);
}
