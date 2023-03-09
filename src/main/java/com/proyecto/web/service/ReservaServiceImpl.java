package com.proyecto.web.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.IReservaRepo;
import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.repository.model.Pago;
import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.to.ReporteReservasTO;
import com.proyecto.web.service.to.ReservaTO;
import com.proyecto.web.service.to.RespuestaReservaTO;

import jakarta.transaction.Transactional;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepo iReservaRepo;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IClienteService iClienteService;

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
	public RespuestaReservaTO registrarReserva(ReservaTO reservaTO) {

		String codigoReserva = reservaTO.getPlaca() + "-" + reservaTO.getFechaInicio() + "-"
				+ reservaTO.getFechaFinal();

		Cliente cliente = this.iClienteService.buscarPorCedulaParaReserva(reservaTO.getCedula());
		Vehiculo vehiculo = this.iVehiculoService.buscarPorPlaca(reservaTO.getPlaca());
		
		Reserva reserva = new Reserva();
		reserva.setEstado('G');
		reserva.setFechaFinal(reservaTO.getFechaFinal().atStartOfDay());
		reserva.setFechaInicio(reservaTO.getFechaInicio().atStartOfDay());
		reserva.setNumero(codigoReserva);
		reserva.setClienteReserva(cliente);
		reserva.setVehiculoReservado(vehiculo);

		Integer dias = Period.between(reservaTO.getFechaInicio(), reservaTO.getFechaFinal()).getDays();
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

		RespuestaReservaTO respuestaReservaTO = new RespuestaReservaTO();
		respuestaReservaTO.setNumeroReserva(codigoReserva);

		return respuestaReservaTO;
	}
	
	@Override
	public List<ReporteReservasTO> reporteReservas(LocalDateTime inicio, LocalDateTime fin) {
		return this.iReservaRepo.reporteReservas(inicio, fin);
	}
	
	@Override
	public List<Reserva> buscarPorReservasPorFecha(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.iReservaRepo.buscarPorReservasPorFecha(placa, fechaInicio, fechaFin);
	}


}
