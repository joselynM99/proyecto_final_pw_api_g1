package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IVehiculoService;
import com.proyecto.web.service.to.ResultadoDisponibilidadVehiculoTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;

@RestController
@CrossOrigin
@RequestMapping("/vehiculos")
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService iVehiculoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private List<VehiculoDisponiblesTO> vehiculosDisponibles(@RequestParam("marca") String marca,
			@RequestParam("modelo") String modelo) {
		return this.iVehiculoService.buscarMarcaModelo(marca, modelo);
	}

	@GetMapping(path = "/marcas", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<String> todasMarcas() {
		return this.iVehiculoService.todasMarcas();
	}

	@GetMapping(path = "/modelos", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<String> todosModelos() {
		return this.iVehiculoService.todosModelos();
	}

	@GetMapping(path = "/porPlaca/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResultadoDisponibilidadVehiculoTO verificarDisponibilidad(@PathVariable("placa") String placa,
			@RequestParam("inicio") String inicio, @RequestParam("fin") String fin) {
		return this.iVehiculoService.verificarDiponibilidad(inicio, fin, placa);
	}
}
