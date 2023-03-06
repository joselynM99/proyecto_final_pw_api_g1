package com.proyecto.web.service;

import com.proyecto.web.modelo.Vehiculo;

public interface IVehiculoService {

	// CRUD
	void insertar(Vehiculo vehiculo);

	void actualizar(Vehiculo vehiculo);

	Vehiculo buscar(Integer id);

	void borrar(Integer id);

}
