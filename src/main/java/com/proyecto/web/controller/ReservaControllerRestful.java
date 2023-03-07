package com.proyecto.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.TO.ReporteReservasTO;
import com.proyecto.web.service.TO.ReservaTO;

@RestController
@CrossOrigin
@RequestMapping("/reservas")
public class ReservaControllerRestful {

	@Autowired
	private IReservaService iReservaService;

	@PostMapping
	private void registrarReserva(@RequestBody ReservaTO reservaTO) {
		this.iReservaService.registrarReserva(reservaTO);
	}
	
	@GetMapping
	private List<ReporteReservasTO> reporteReservasFechas(@RequestParam("inicio") LocalDate inicio,
			@RequestParam("fin") LocalDate fin) {
		return this.iReservaService.reporteReservas(inicio, fin);
	}

}
