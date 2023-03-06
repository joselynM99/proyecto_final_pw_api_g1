package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.modelo.Vehiculo;
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
	
	//Buscar Cliente
	
	
	
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

}
