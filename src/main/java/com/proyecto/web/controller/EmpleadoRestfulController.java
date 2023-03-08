package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.proyecto.web.repository.model.Cliente;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.IGestorEmpleadoService;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/empleados")

public class EmpleadoRestfulController {

	@Autowired
	private IGestorEmpleadoService iGestorEmpleadoService;

	// Insertar vehiculo

	@PostMapping(path = "/vehiculoNuevo", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String insertarVehiculo(@RequestBody Vehiculo vehiculo) {
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
	public Cliente buscarClientePorId(@PathVariable("id") Integer id) {

		return this.iGestorEmpleadoService.buscarPorId(id);
	}

	// Lista de Clientes por Apellido
	@GetMapping(path = "/listaClientes/{apellido}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Cliente> buscarClientes(@PathVariable("apellido") String apellido) {

		return this.iGestorEmpleadoService.buscarPorApellido(apellido);
	}

	// Actualizar Cliente
	@PutMapping(path="/clientes",consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String actualizarCliente(@RequestBody Cliente cliente) {
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
