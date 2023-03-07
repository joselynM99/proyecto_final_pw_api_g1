package com.proyecto.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.proyecto.web.repository.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class
				, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente>myQuery=this.entityManager.createQuery("select c from Cliente c where c.apellido=:apellido",Cliente.class);
		myQuery.setParameter("apellido",apellido);
		
		return myQuery.getResultList();
	}

	@Override
	public void borrarPorApellido(String apellido) {
		// TODO Auto-generated method stub

	}

}
