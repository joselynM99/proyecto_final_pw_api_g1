package com.proyecto.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.TO.ReporteReservasTO;

@RestController
@CrossOrigin
@RequestMapping("/reportes")
public class ReporteControllerRestful {

	@Autowired
	private IReservaService iReservaService;

	@GetMapping(path = "/vehiculos")
	private List<ReporteReservasTO> reporteReservasFechas(@RequestParam("inicio") LocalDate inicio,
			@RequestParam("fin") LocalDate fin) {
		return this.iReservaService.reporteReservas(inicio, fin);
	}
}
