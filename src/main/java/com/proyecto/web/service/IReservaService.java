package com.proyecto.web.service;

import java.time.LocalDateTime;
import java.util.List;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ReporteReservasTO;
import com.proyecto.web.service.to.ReservaTO;

public interface IReservaService {

	void insertar(Reserva reserva);

	void actualizar(Reserva reserva);

	Reserva buscar(Integer id);

	void borrar(Integer id);

	Reserva buscarPorNumero(String numero);

	List<Reserva> buscarPorVehiculo(Vehiculo vehiculo);

	List<Reserva> todasReservas();

	void registrarReserva(ReservaTO reservaTO);

	List<ReporteReservasTO> reporteReservas(LocalDateTime atStartOfDay, LocalDateTime atStartOfDay2);

}
