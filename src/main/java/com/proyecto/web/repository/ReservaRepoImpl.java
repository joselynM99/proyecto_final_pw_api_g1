package com.proyecto.web.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.TO.ReporteReservasTO;


@Transactional
@Repository
public class ReservaRepoImpl implements IReservaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Reserva reserva) {
		this.entityManager.persist(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.entityManager.merge(reserva);
	}

	@Override
	public Reserva buscar(Integer id) {
		return this.entityManager.find(Reserva.class, id);

	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Reserva buscarPorNumero(String numero) {
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r FROM Reserva r WHERE r.numero=: numero",
				Reserva.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}


	@Override
	public List<Reserva> buscarPorVehiculo(Vehiculo vehiculo) {
		TypedQuery<Reserva> myQuery = this.entityManager
				.createQuery("SELECT r  FROM Reserva r where r.vehiculoReservado=:vehiculo", Reserva.class);
		myQuery.setParameter("vehiculo", vehiculo);
		return myQuery.getResultList();
	}

	@Override
	public List<Reserva> todasReservas() {
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r  FROM Reserva r ", Reserva.class);
		return myQuery.getResultList();
	}

	@Override
	public List<ReporteReservasTO> reporteReservas(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		TypedQuery<ReporteReservasTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.proyecto.web.service.TO.ReporteReservasTO(r.id,r.numero,r.fechaInicio,r.fechaFinal,r.estado,c.apellido,c.cedula,v.placa,v.marca,v.valorPorDia) FROM Reserva r JOIN r.clienteReserva c JOIN r.vehiculoReservado v  WHERE r.fechaInicio>=:fechaInicio AND  r.fechaFinal<=:fechaFinal",
				ReporteReservasTO.class);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFinal", fechaFinal);
		return myQuery.getResultList();
	}

}
