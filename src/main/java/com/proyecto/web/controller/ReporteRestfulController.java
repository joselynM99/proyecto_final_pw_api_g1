package com.proyecto.web.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IGestorReportesService;
import com.proyecto.web.service.to.VehiculoVip;

@RestController
@RequestMapping("/reportes")
public class ReporteRestfulController {
	
	@Autowired
	private IGestorReportesService iGestorReportesService;

	@GetMapping(path = "/VehiculoVip", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<VehiculoVip> vehiculoVip(@RequestParam ("fechaInicio") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fechaInicio){
		Month mes=fechaInicio.getMonth();
		int anio= fechaInicio.getYear();
		
		List<VehiculoVip> listaVehiculoVip= this.iGestorReportesService.reporteVehiculoVip(mes, Year.of(anio));
		return listaVehiculoVip;
	}
}
