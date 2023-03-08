package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.TO.ReservaTO;

@RestController
@CrossOrigin
@RequestMapping("/reservas")
public class ReservasControllerRestful {

	@Autowired
	private IReservaService iReservasService;

	@PostMapping
	private void registrarReserva(@RequestBody ReservaTO reservaTO) {
		this.iReservasService.registrarReserva(reservaTO);
	}

}
