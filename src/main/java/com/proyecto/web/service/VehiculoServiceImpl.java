package com.proyecto.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IVehiculoRepository;
import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Override
    public void insertarVehiculo(VehiculoTo vehiculo) {
        this.vehiculoRepository.insertarVehiculo(vehiculo.toVehiculo());
    }

    @Override
    public void actualizarVehiculo(VehiculoTo vehiculo) {
        this.vehiculoRepository.actualizarVehiculo(vehiculo.toVehiculo());
    }

    @Override
    public void eliminarVehiculo(Integer id) {
        this.vehiculoRepository.eliminarVehiculo(id);
    }

    @Override
    public VehiculoTo buscarVehiculo(Integer id) {
        return this.vehiculoRepository.buscarVehiculo(id).toVehiculoTo();
    }

    @Override
    public List<VehiculoTo> buscarVehiculosPorMarca(String marca) {
        return this.vehiculoRepository.buscarVehiculosPorMarca(marca).stream().map(vehiculo -> vehiculo.toVehiculoTo()).collect(Collectors.toList());
    }

    @Override
    public VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero) {
        return this.vehiculoRepository.buscarVehiculoPorNumeroDeReserva(numero);
    }
    
}
