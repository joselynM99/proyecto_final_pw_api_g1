package com.proyecto.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.proyecto.web.modelo.Vehiculo;
import com.proyecto.web.service.to.VehiculoReservadoTo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

    @Override
    public void insertarVehiculo(Vehiculo vehiculo) {
        this.entityManager.persist(vehiculo);
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        this.entityManager.merge(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Integer id) {
        this.entityManager.remove(this.buscarVehiculo(id));    
    }

    @Override
    public Vehiculo buscarVehiculo(Integer id) {
        return this.entityManager.find(Vehiculo.class,id);
    }

    @Override
    public List<Vehiculo> buscarVehiculosPorMarca(String marca) {
        TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca = :marca", Vehiculo.class);
		myQuery.setParameter("marca", marca);
		return myQuery.getResultList();
    }

    @Override
    public VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero) {
        TypedQuery<VehiculoReservadoTo> myQuery = this.entityManager.createQuery("SELECT NEW com.example.demo.service.to.VehiculoReservadoTo(r.numero, v.placa, v.modelo, v.estado, r.fechaInicio, r.fechaFinal, v.id, r.id) FROM Vehiculo v JOIN Reserva r ON r.vehiculoReservado = v WHERE r.numero = :numero", VehiculoReservadoTo.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
    }
    
}
