package com.proyecto.web.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.web.repository.model.IVA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class IVARepoImpl implements IIVARepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(IVA iva) {
		// TODO Auto-generated method stub
		this.entityManager.persist(iva);
	}

	@Override
	public void actualizar(IVA iva) {
		// TODO Auto-generated method stub
		this.entityManager.merge(iva);
	}

	@Override
	public IVA buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(IVA.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
