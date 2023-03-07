package com.proyecto.web.service;

import java.time.Month;
import java.time.Year;
import java.util.List;

import com.proyecto.web.service.TO.VehiculoVip;

public interface IGestorReportesService {

	List <VehiculoVip> reporteVehiculoVip(Month mes, Year anio);
}
