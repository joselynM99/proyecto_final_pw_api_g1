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
	public boolean insertar(Cliente cliente) {
		this.entityManager.persist(cliente);

		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("select c from Cliente c where c.apellido=:apellido", Cliente.class);
		myQuery.setParameter("apellido", apellido);

		return myQuery.getResultList();
	}


	@Override
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula",
				Cliente.class);
		myQuery.setParameter("cedula", cedula);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Cliente buscarPorCedulaParaReserva(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula",
				Cliente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Cliente> buscarPagosClientes() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Cliente c LEFT JOIN FETCH c.reservas r LEFT JOIN FETCH r.pagos", Cliente.class);

		try {
			return myQuery.getResultList();
		} catch (Exception e) {

			return null;
		}
	}

}
