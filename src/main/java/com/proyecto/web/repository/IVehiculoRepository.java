package com.proyecto.web.repository;

import java.util.List;

import com.proyecto.web.modelo.Vehiculo;
import com.proyecto.web.service.to.VehiculoReservadoTo;

public interface IVehiculoRepository {
    void insertarVehiculo(Vehiculo vehiculo);
    void actualizarVehiculo(Vehiculo vehiculo);
    void eliminarVehiculo(Integer id);
    Vehiculo buscarVehiculo(Integer id);
    List<Vehiculo> buscarVehiculosPorMarca(String marca);
    VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero);
}
