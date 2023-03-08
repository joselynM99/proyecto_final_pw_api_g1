package com.proyecto.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.to.ReporteReservasTO;
import com.proyecto.web.service.to.ReservaTO;
import com.proyecto.web.service.to.RespuestaReservaTO;

@RestController
@CrossOrigin
@RequestMapping("/reservas")
public class ReservaControllerRestful {

	@Autowired
	private IReservaService iReservaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private RespuestaReservaTO registrarReserva(@RequestBody ReservaTO reservaTO) {
		return this.iReservaService.registrarReserva(reservaTO);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private List<ReporteReservasTO> reporteReservasFechas(@RequestParam("inicio") String inicio,
			@RequestParam("fin") String fin) {
		return this.iReservaService.reporteReservas(LocalDate.parse(inicio), LocalDate.parse(fin));
	}

}
