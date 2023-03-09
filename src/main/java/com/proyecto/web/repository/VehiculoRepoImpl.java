package com.proyecto.web.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.VehiculoReservadoTo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Vehiculo buscar(Integer id) {
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=: placa",
				Vehiculo.class);
		myQuery.setParameter("placa", placa);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarMarcaModelo(String marca, String modelo) {
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=: marca AND v.modelo=:modelo", Vehiculo.class);
		myQuery.setParameter("marca", marca);
		myQuery.setParameter("modelo", modelo);
		return myQuery.getResultList();
	}

	@Override
	public List<Vehiculo> todosVehiculos() {
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
		return myQuery.getResultList();
	}
	@Override
	public List<Vehiculo> buscarVehiculosPorMarca(String marca) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca = :marca", Vehiculo.class);
		myQuery.setParameter("marca", marca);
		return myQuery.getResultList();
	}

	@Override
	public VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero) {
		TypedQuery<VehiculoReservadoTo> myQuery = this.entityManager.createQuery("SELECT NEW com.proyecto.web.service.to.VehiculoReservadoTo(r.numero, v.placa, v.modelo, v.estado, r.fechaInicio, r.fechaFinal, c.cedula, v.id, r.id) FROM Vehiculo v JOIN Reserva r ON r.vehiculoReservado = v JOIN Cliente c ON r.clienteReserva = c WHERE r.numero = :numero", VehiculoReservadoTo.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
