package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IClienteService;
import com.proyecto.web.service.IGestorEmpleadoService;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;
import com.proyecto.web.service.to.VehiculoTO;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/empleados")

public class EmpleadoRestfulController {

	@Autowired
	private IGestorEmpleadoService iGestorEmpleadoService;
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(path = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registrarCliente(@RequestBody ClienteTO cliente) {
		this.clienteService.registrar(cliente);
	}

	// Insertar vehiculo

	@PostMapping(path = "/vehiculoNuevo", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String insertarVehiculo(@RequestBody VehiculoTO vehiculo) {
		String msj = "Vehiculo ingresado correctamente";
		try {
			this.iGestorEmpleadoService.ingresarVehiculo(vehiculo);
		} catch (Exception e) {
			msj = "Error al ingresar el vehiculo" + e;
		}

		return msj;

	}

	// Buscar Cliente

	@GetMapping(path = "/clientes/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ClienteActualizarTO buscarClientePorId(@PathVariable("id") Integer id) {

		return this.iGestorEmpleadoService.buscarPorId(id);
	}

	// Lista de Clientes por Apellido
	@GetMapping(path = "/listaClientes/{apellido}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteActualizarTO> buscarClientes(@PathVariable("apellido") String apellido) {

		return this.iGestorEmpleadoService.buscarPorApellido(apellido);
	}

	// Actualizar Cliente
	@PutMapping(path="/clientes",consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String actualizarCliente(@RequestBody ClienteActualizarTO cliente) {
		String msj = "Cliente actualizado correctamente";
		try {
			this.iGestorEmpleadoService.actualizarCliente(cliente);
		} catch (Exception e) {
			msj = "Error al actualizar cliente" + e;
		}

		return msj;

	}

	// Eliminar Cliente
	@DeleteMapping(path = "/clientes/{id}")
	public String eliminarCliente(@PathVariable("id") Integer id) {
		String msj = "Cliente eliminado correctamente";
		try {
			this.iGestorEmpleadoService.eliminarClienteId(id);
		} catch (Exception e) {
			msj = "Error al eliminar cliente" + e;
		}

		return msj;

	}

}
