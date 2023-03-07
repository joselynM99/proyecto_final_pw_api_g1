package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IVehiculoService;
import com.proyecto.web.service.to.ParametrosBuscarVehiculoTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;

@RestController
@CrossOrigin
@RequestMapping("/vehiculos")
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService iVehiculoService;

	@GetMapping
	private List<VehiculoDisponiblesTO> vehiculosDisponibles(@RequestParam("marca") String marca,
			@RequestParam("modelo") String modelo) {
		return this.iVehiculoService.buscarMarcaModelo(marca, modelo);
	}

	@GetMapping(path = "/marcas")
	private List<String> todasMarcas() {
		return this.iVehiculoService.todasMarcas();
	}

	@GetMapping(path = "/modelos")
	private List<String> todosModelos() {
		return this.iVehiculoService.todosModelos();
	}

	@GetMapping(path = "/porPlaca/{placa}")
	private ParametrosBuscarVehiculoTO verificarDisponibilidad(@PathVariable("placa") String placa,
			@RequestParam("inicio") String inicio, @RequestParam("fin") String fin) {
		return this.iVehiculoService.verificarDiponibilidad(inicio, fin, placa);
	}
}
