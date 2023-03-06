package com.proyecto.web.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;

public interface IReservaRepo {

	void insertar(Reserva reserva);

	void actualizar(Reserva reserva);

	Reserva buscar(Integer id);

	void borrar(Integer id);

	Reserva buscarPorNumero(String numero);

	List<Reserva> buscarPorVehiculo(Vehiculo vehiculo);


	List<Reserva> todasReservas();

}
