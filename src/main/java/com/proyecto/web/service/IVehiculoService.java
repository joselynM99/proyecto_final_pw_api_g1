package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTo;

public interface IVehiculoService {
    void insertarVehiculo(VehiculoTo vehiculo);
    void actualizarVehiculo(VehiculoTo vehiculo);
    void eliminarVehiculo(Integer id);
    VehiculoTo buscarVehiculo(Integer id);
    List<VehiculoTo> buscarVehiculosPorMarca(String marca);
    VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero);
}
