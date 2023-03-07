package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/empleados")
public class EmpleadoRestfulController {

	@Autowired
	private IGestorEmpleadoService iGestorEmpleadoService;
	
	//Insertar vehiculo

	@PostMapping(path="/vehiculo",consumes ={ MediaType.APPLICATION_JSON_VALUE } )
	public void insertarVehiculo(@RequestBody Vehiculo vehiculo) {
		this.iGestorEmpleadoService.ingresarVehiculo(vehiculo);
	}
	
	
	// Jorgee empiezaa
	//Buscar Cliente
	
	
	//Lista de Empleados
	@GetMapping(path = "/{apellido}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Cliente> buscarClientes(@PathVariable("apellido")String apellido){
		
		return this.iGestorEmpleadoService.buscarPorApellido(apellido);
	}
	
	
	//Actualizar Cliente
	@PutMapping(path="/{id}",consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		this.iGestorEmpleadoService.actualizarCliente(cliente);
	}
	
	//Eliminar Cliente
	@DeleteMapping(path="/id")
	public void eliminarCliente(@RequestBody Cliente cliente) {
		this.iGestorEmpleadoService.eliminarCliente(cliente);
	}

	// Jorge termina
}
