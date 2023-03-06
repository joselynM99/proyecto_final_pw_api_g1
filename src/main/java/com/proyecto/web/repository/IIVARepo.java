package com.proyecto.web.repository;

import com.proyecto.web.modelo.IVA;

public interface IIVARepo {

	// CRUD
	void insertar(IVA iva);

	void actualizar(IVA iva);

	IVA buscar(Integer id);

	void borrar(Integer id);
}
