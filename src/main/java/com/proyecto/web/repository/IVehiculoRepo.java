package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.VehiculoReservadoTo;

public interface IVehiculoRepo {

	void insertar(Vehiculo vehiculo);

	void actualizar(Vehiculo vehiculo);

	void borrar(Integer id);

	Vehiculo buscar(Integer id);

	Vehiculo buscarPorPlaca(String placa);

	List<Vehiculo> buscarMarcaModelo(String marca, String modelo);

	List<Vehiculo> buscarVehiculosPorMarca(String marca);
    
	VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero);

	List<Vehiculo> todosVehiculos();

}
