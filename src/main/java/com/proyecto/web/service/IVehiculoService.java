package com.proyecto.web.service;

import java.util.List;

import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ResultadoDisponibilidadVehiculoTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;
import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTO;

public interface IVehiculoService {

	void insertar(VehiculoTO vehiculo);

	void actualizar(Vehiculo vehiculo);

	Vehiculo buscar(Integer id);

	void borrar(Integer id);

	Vehiculo buscarPorPlaca(String placa);

	List<VehiculoDisponiblesTO> buscarMarcaModelo(String marca, String modelo);

	List<VehiculoTO> buscarVehiculosPorMarca(String marca);
    
	VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero);

	List<String> todasMarcas();

	List<String> todosModelos();

	ResultadoDisponibilidadVehiculoTO verificarDiponibilidad(String inicio, String fin, String placa);
}
