package com.proyecto.web.service;

import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.service.TO.VehiculoVip;

@Service
public class GestorReportesServiceImpl implements IGestorReportesService {

	@Autowired
	private IReservaService iReservaService;
	
	@Override
	public List<VehiculoVip> reporteVehiculoVip(Month mes, Year anio) {
		// TODO Auto-generated method stub
		List<Reserva> listaTodos = this.iReservaService.todasReservas();
		int anioComparar = anio.getValue();
		int mesComparar = mes.getValue();

		// Comparacion de fechas y filtrado para insertar en vehiculo vip
		Stream<VehiculoVip> listaUno = listaTodos.parallelStream()
				.filter(reserva -> (reserva.getPagos().getFechaCobro().getMonthValue() == mesComparar)
						&& (reserva.getPagos().getFechaCobro().getYear() == anioComparar))
				.map(vehiculo -> {
					VehiculoVip vehiculo1 = new VehiculoVip();
					vehiculo1.setId(vehiculo.getVehiculoReservado().getId());
					vehiculo1.setPlaca(vehiculo.getVehiculoReservado().getPlaca());
					vehiculo1.setMarca(vehiculo.getVehiculoReservado().getMarca());
					vehiculo1.setModelo(vehiculo.getVehiculoReservado().getModelo());
					vehiculo1.setValorSubtotal(vehiculo.getPagos().getValorSubTotal());
					vehiculo1.setValorTotal(vehiculo.getPagos().getValorTotalAPagar());

					return vehiculo1;
				});
		
		//Transofrmar el stream en lista
		List<VehiculoVip> listaConvertida=listaUno.collect(Collectors.toList());
		
		//Agrupamiento y ordenamiento
		List<VehiculoVip> listaReducida=listaConvertida.parallelStream()
				.collect(Collectors.groupingBy(VehiculoVip::getId)).entrySet().parallelStream()
				.map(vehiculo->vehiculo.getValue().parallelStream()
						.reduce((vehiculo1,vehiculo2)->  new VehiculoVip(vehiculo1.getId(),vehiculo1.getPlaca(),
								vehiculo1.getMarca(), vehiculo1.getModelo(),
								vehiculo1.getValorSubtotal().add(vehiculo2.getValorSubtotal()),
								vehiculo1.getValorTotal().add(vehiculo2.getValorTotal()))))
				.map(vehiculo->vehiculo.get()).sorted(Comparator.comparing(VehiculoVip::getValorTotal).reversed())
				.collect(Collectors.toList());
		return listaReducida;
	}

}
