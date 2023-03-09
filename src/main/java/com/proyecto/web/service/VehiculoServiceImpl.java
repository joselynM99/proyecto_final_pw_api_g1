package com.proyecto.web.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IReservaRepo;
import com.proyecto.web.repository.IVehiculoRepo;
import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ResultadoDisponibilidadVehiculoTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;
import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTO;

import jakarta.transaction.Transactional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo iVehiculoRepo;

	@Autowired
	private IReservaRepo iReservaRepo;

	private static final Logger LOG = Logger.getRootLogger();

	@Override
	@Transactional
	public void insertar(VehiculoTO vehiculo) {
		LOG.info("Insertando vehiculo...");
		this.iVehiculoRepo.insertar(convertirVehiculoTOAVehiculo(vehiculo));
	}

	@Override
	@Transactional
	public void actualizar(Vehiculo vehiculo) {
		LOG.info("Actualizando vehiculo...");
		this.iVehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		LOG.info("Buscando vehiculo por id: " + id);
		return this.iVehiculoRepo.buscar(id);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.iVehiculoRepo.borrar(id);
	}

	@Override
	public List<VehiculoDisponiblesTO> buscarMarcaModelo(String marca, String modelo) {
		LOG.info("Buscando vehiculo por marca: " + marca + " y por modelo: " + modelo);
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.buscarMarcaModelo(marca, modelo);
		return listVehiculos.stream().map(v -> convertirVehiculoATO(v)).collect(Collectors.toList());
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		LOG.info("Buscando vehiculo por placa: " + placa);

		return this.iVehiculoRepo.buscarPorPlaca(placa);
	}

	@Override
	public List<String> todasMarcas() {
		LOG.info("Obteniendo todas las marcas de vehiculos");
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.todosVehiculos();
		return listVehiculos.stream().map(Vehiculo::getMarca).distinct().collect(Collectors.toList());
	}

	@Override
	public List<String> todosModelos() {
		LOG.info("Obteniendo todas las modelos de vehiculos");
		List<Vehiculo> listVehiculos = this.iVehiculoRepo.todosVehiculos();
		return listVehiculos.stream().map(Vehiculo::getModelo).distinct().collect(Collectors.toList());
	}

	@Override
	public ResultadoDisponibilidadVehiculoTO verificarDiponibilidad(String inicio, String fin, String placa) {
		LOG.info("Verificando disponibilidad de vehiculo con placa: " +placa + "desde: " +inicio+ " hasta: "+fin);
		try {
			ResultadoDisponibilidadVehiculoTO temp = new ResultadoDisponibilidadVehiculoTO();
			Vehiculo vehiculo = this.buscarPorPlaca(placa);

			List<Reserva> reservasFechasSolapadas = this.iReservaRepo.buscarPorReservasPorFecha(placa,
					LocalDate.parse(inicio).atStartOfDay(), LocalDate.parse(fin).atStartOfDay());

			if (reservasFechasSolapadas.isEmpty() || reservasFechasSolapadas == null) {
				LOG.info("Vehiculo disponible");
				temp.setEstado("D");
			} else {
				LOG.info("Vehiculo no disponible");
				temp.setEstado("ND");
				temp.setFechaDisponible(reservasFechasSolapadas.stream().map(r -> r.getFechaFinal())
						.max(LocalDateTime::compareTo).get().plusDays(1).toLocalDate());
			}
			Integer dias = Period.between(LocalDate.parse(inicio), (LocalDate.parse(fin))).getDays();
			BigDecimal valorSubTotal = vehiculo.getValorPorDia().multiply(new BigDecimal(dias));
			BigDecimal valorIVA = (valorSubTotal.multiply(new BigDecimal(12))).divide(new BigDecimal(100));
			BigDecimal valorTotalAPagar = valorSubTotal.add(valorIVA);
			temp.setValorTotalPagar(valorTotalAPagar);
			return temp;
		} catch (Exception e) {
			LOG.info("Vehiculo no disponible");
			ResultadoDisponibilidadVehiculoTO temp = new ResultadoDisponibilidadVehiculoTO();
			temp.setEstado("ND");
			return temp;
		}
	}

	@Override
	public List<VehiculoTO> buscarVehiculosPorMarca(String marca) {
		LOG.info("Buscar vehiculos por marca: " +marca);
		return this.iVehiculoRepo.buscarVehiculosPorMarca(marca).stream()
				.map(vehiculo -> this.convertirVehiculoAVehiculoTo(vehiculo)).collect(Collectors.toList());
	}

	@Override
	public VehiculoReservadoTo buscarVehiculoPorNumeroDeReserva(String numero) {
		LOG.info("Buscar vehiculos por numero de reserva: " +numero);
		return this.iVehiculoRepo.buscarVehiculoPorNumeroDeReserva(numero);
	}

	private Vehiculo convertirVehiculoTOAVehiculo(VehiculoTO vehiculo) {
		Vehiculo vehiculo1 = new Vehiculo();
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

	private VehiculoTO convertirVehiculoAVehiculoTo(Vehiculo vehiculo) {
		VehiculoTO vehiculo1 = new VehiculoTO();
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
}
