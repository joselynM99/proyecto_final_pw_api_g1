package com.proyecto.web.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import com.proyecto.web.service.to.ClienteVIPTO;

import com.proyecto.web.service.to.VehiculoVipTO;

import com.proyecto.web.service.to.ReporteReservasTO;


public interface IGestorReportesService {

	List <VehiculoVipTO> reporteVehiculoVip(Month mes, Year anio);

	List<ClienteVIPTO> buscarClientesVIP();

	List<ReporteReservasTO> reporteReservas(LocalDate parse, LocalDate parse2);
}
