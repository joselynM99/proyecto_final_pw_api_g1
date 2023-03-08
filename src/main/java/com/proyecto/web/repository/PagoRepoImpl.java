package com.proyecto.web.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.web.repository.model.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class PagoRepoImpl implements IPagoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Pago pago) {
		// TODO Auto-generated method stub
		this.entityManager.persist(pago);
	}

	@Override
	public void actualizar(Pago pago) {
		// TODO Auto-generated method stub
		this.entityManager.merge(pago);
	}

	@Override
	public Pago buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Pago.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
