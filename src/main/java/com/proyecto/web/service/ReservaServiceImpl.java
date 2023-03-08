package com.proyecto.web.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IReservaRepo;
import com.proyecto.web.repository.model.Pago;
import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.TO.ParametrosBuscarVehiculoTO;
import com.proyecto.web.service.TO.ReservaTO;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepo iReservaRepo;
	@Autowired
	private IVehiculoService iVehiculoService;

	@Override
	@Transactional
	public void insertar(Reserva reserva) {
		this.iReservaRepo.insertar(reserva);
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.iReservaRepo.actualizar(reserva);
	}

	@Override
	public Reserva buscar(Integer id) {
		return this.iReservaRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.iReservaRepo.borrar(id);
	}

	@Override
	public Reserva buscarPorNumero(String numero) {
		return this.iReservaRepo.buscarPorNumero(numero);
	}

	@Override
	public List<Reserva> buscarPorVehiculo(Vehiculo vehiculo) {
		return this.iReservaRepo.buscarPorVehiculo(vehiculo);
	}

	@Override
	public List<Reserva> todasReservas() {
		return this.iReservaRepo.todasReservas();
	}

	@Override
	public void registrarReserva(ReservaTO reservaTO) {

		Reserva reserva = new Reserva();
		reserva.setEstado('G');
		reserva.setFechaFinal(reservaTO.getFechaFinal().atStartOfDay());
		reserva.setFechaInicio(reservaTO.getFechaInicio().atStartOfDay());
		reserva.setNumero(reservaTO.getPlaca() + "--" + reservaTO.getFechaInicio() + "--" + reservaTO.getFechaFinal());
		

		Vehiculo vehiculo = this.iVehiculoService.buscarPorPlaca(reservaTO.getPlaca());
		Integer dias = Period.between(reservaTO.getFechaInicio(), reservaTO.getFechaFinal())
				.getDays();
		BigDecimal valorSubTotal = vehiculo.getValorPorDia().multiply(new BigDecimal(dias));
		BigDecimal valorIVA = (valorSubTotal.multiply(new BigDecimal(12))).divide(new BigDecimal(100));
		BigDecimal valorTotalAPagar = valorSubTotal.add(valorIVA);
		
		Pago pago = new Pago();
		pago.setFechaCobro(LocalDateTime.now());
		pago.setTarjeta(reservaTO.getTarjeta());
		pago.setValorIVA(valorIVA);
		pago.setValorSubTotal(valorSubTotal);
		pago.setValorTotalAPagar(valorTotalAPagar);
		pago.setPagoReserva(reserva);
		reserva.setPagos(pago);
		
		this.insertar(reserva);
	}

}
