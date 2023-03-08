package com.proyecto.web.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IVehiculoRepo;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ParametrosBuscarVehiculoTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;
import com.proyecto.web.service.to.VehiculoTO;

import jakarta.transaction.Transactional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo iVehiculoRepo;

	@Override
	@Transactional
	public void insertar(VehiculoTO vehiculo) {
		this.iVehiculoRepo.insertar(convertirVehiculoTOAVehiculo(vehiculo));
	}

	@Override
	@Transactional
	public void actualizar(Vehiculo vehiculo) {
		this.iVehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		return this.iVehiculoRepo.buscar(id);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.iVehiculoRepo.borrar(id);
	}

	@Override
	public List<VehiculoDisponiblesTO> buscarMarcaModelo(String marca, String modelo) {
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.buscarMarcaModelo(marca, modelo);
		return listVehiculos.stream().map(v -> convertirVehiculoATO(v)).collect(Collectors.toList());
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		return this.iVehiculoRepo.buscarPorPlaca(placa);
	}

	private VehiculoDisponiblesTO convertirVehiculoATO(Vehiculo vehiculo) {
		VehiculoDisponiblesTO v = new VehiculoDisponiblesTO();
		v.setAnioFabricacion(vehiculo.getAnioFabricacion());
		v.setEstado((vehiculo.getEstado().compareTo("D") == 0) ? "DISPONIBLE" : "NO DISPONIBLE");
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setPlaca(vehiculo.getPlaca());
		v.setValorPorDia(vehiculo.getValorPorDia());
		return v;
	}

	@Override
	public List<String> todasMarcas() {
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.todosVehiculos();
		return listVehiculos.stream().map(Vehiculo::getMarca).distinct().collect(Collectors.toList());
	}

	@Override
	public List<String> todosModelos() {
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.todosVehiculos();
		return listVehiculos.stream().map(Vehiculo::getModelo).distinct().collect(Collectors.toList());
	}

	@Override
	public ParametrosBuscarVehiculoTO verificarDiponibilidad(String inicio, String fin, String placa) {
		Vehiculo vehiculo = this.iVehiculoRepo.buscarPorPlaca(placa);

		ParametrosBuscarVehiculoTO temp = new ParametrosBuscarVehiculoTO();
		temp.setEstado(vehiculo.getEstado());
		Integer dias = Period.between(LocalDate.parse(inicio), (LocalDate.parse(fin))).getDays();
		BigDecimal valorSubTotal = vehiculo.getValorPorDia().multiply(new BigDecimal(dias));
		BigDecimal valorIVA = (valorSubTotal.multiply(new BigDecimal(12))).divide(new BigDecimal(100));
		BigDecimal valorTotalAPagar = valorSubTotal.add(valorIVA);
		temp.setValorTotalPagar(valorTotalAPagar);
		return temp;
	}
	
	private Vehiculo convertirVehiculoTOAVehiculo(VehiculoTO vehiculo) {
		Vehiculo vehiculo1=new Vehiculo();
		vehiculo1.setAnioFabricacion(vehiculo.getAnioFabricacion());
		vehiculo1.setAvaluo(vehiculo.getAvaluo());
		vehiculo1.setCilindraje(vehiculo.getCilindraje());
		vehiculo1.setEstado(vehiculo.getEstado());
		vehiculo1.setId(vehiculo.getId());
		vehiculo1.setMarca(vehiculo.getMarca());
		vehiculo1.setModelo(vehiculo.getModelo());
		vehiculo1.setPais(vehiculo.getPais());
		vehiculo1.setPlaca(vehiculo.getPlaca());
		vehiculo1.setValorPorDia(vehiculo.getValorPorDia());
		
		return vehiculo1;
		
	}
}
