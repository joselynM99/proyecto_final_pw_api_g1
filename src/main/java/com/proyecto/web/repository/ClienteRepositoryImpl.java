package com.proyecto.web.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.web.modelo.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula", Cliente.class);
		myQuery.setParameter("cedula", cedula);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

}
