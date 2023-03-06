package com.proyecto.web.repository;

import com.proyecto.web.modelo.Vehiculo;

public interface IVehiculoRepo {

	// CRUD
	void insertar(Vehiculo vehiculo);

	void actualizar(Vehiculo vehiculo);

	void borrar(Integer id);

	Vehiculo buscar(Integer id);
}
