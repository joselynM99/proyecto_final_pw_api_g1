package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IClienteService;
import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.IVehiculoService;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;
import com.proyecto.web.service.to.ResultadoDisponibilidadVehiculoTO;
import com.proyecto.web.service.to.ReservaTO;
import com.proyecto.web.service.to.RespuestaReservaTO;
import com.proyecto.web.service.to.VehiculoDisponiblesTO;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteRestfulController {
	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservasService;
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registrarCliente(@RequestBody ClienteTO cliente) {
		 this.clienteService.registrar(cliente);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody ClienteActualizarTO cliente) {
		cliente.setId(id);
		 this.clienteService.actualizar(cliente);
	}
	
	@GetMapping(path="/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteActualizarTO buscarClientePorCedula(@PathVariable("cedula") String cedula) {
		return this.clienteService.encontrarPorCedula(cedula);
	}
	
	@PostMapping(path = "/reservas",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private RespuestaReservaTO registrarReserva(@RequestBody ReservaTO reservaTO) {
		return this.iReservasService.registrarReserva(reservaTO);
	}
	

	@GetMapping(path = "/vehiculos",produces = MediaType.APPLICATION_JSON_VALUE)
	private List<VehiculoDisponiblesTO> vehiculosDisponibles(@RequestParam("marca") String marca,
			@RequestParam("modelo") String modelo) {
		return this.iVehiculoService.buscarMarcaModelo(marca, modelo);
	}

	@GetMapping(path = "/vehiculos/marcas",produces = MediaType.APPLICATION_JSON_VALUE)
	private List<String> todasMarcas() {
		return this.iVehiculoService.todasMarcas();
	}

	@GetMapping(path = "/vehiculos/modelos",produces = MediaType.APPLICATION_JSON_VALUE)
	private List<String> todosModelos() {
		return this.iVehiculoService.todosModelos();
	}

	@GetMapping(path = "/vehiculos/porPlaca/{placa}",produces = MediaType.APPLICATION_JSON_VALUE)
	private ResultadoDisponibilidadVehiculoTO verificarDisponibilidad(@PathVariable("placa") String placa,
			@RequestParam("inicio") String inicio, @RequestParam("fin") String fin) {
		return this.iVehiculoService.verificarDiponibilidad(inicio, fin, placa);
	}

}
