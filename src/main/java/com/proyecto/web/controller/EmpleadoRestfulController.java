package com.proyecto.web.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.IClienteService;
import com.proyecto.web.service.IGestorEmpleadoService;
import com.proyecto.web.service.IReservaService;
import com.proyecto.web.service.IVehiculoService;
import com.proyecto.web.service.to.ClienteActualizarTO;
import com.proyecto.web.service.to.ClienteTO;
import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTO;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/empleados")

public class EmpleadoRestfulController {

	@Autowired
	private IGestorEmpleadoService iGestorEmpleadoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IReservaService reservaService;
	
	@Autowired
    private IVehiculoService vehiculoService;

    @PutMapping(path="/vehiculos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertarVehiculoN(@RequestBody VehiculoTO vehiculo) {
        this.vehiculoService.insertar(vehiculo);
    }

    @PostMapping(path="/vehiculos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarVehiculo(@RequestBody Vehiculo vehiculo) {
        this.vehiculoService.actualizar(vehiculo);
    }

    @DeleteMapping(path = "/vehiculos/{id}")
    public void eliminarVehiculo(@PathVariable("id") Integer id) {
        this.vehiculoService.borrar(id);
    }

    @GetMapping(path = "/vehiculos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehiculo> buscarVehiculo(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.buscar(id));
    }

    @GetMapping(path = "/vehiculos/marca/{marca}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehiculoTO>> buscarVehiculosPorMarca(@PathVariable("marca") String marca) {
        List<VehiculoTO> vehiculoTos = this.vehiculoService.buscarVehiculosPorMarca(marca);
        for (VehiculoTO vehiculoTo : vehiculoTos) {
            Link myLink = linkTo(methodOn(EmpleadoRestfulController.class).buscarVehiculo(vehiculoTo.getId())).withSelfRel();
            vehiculoTo.add(myLink);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoTos);
    }

    @GetMapping(path = "/vehiculos/numero/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoReservadoTo> buscarVehiculoPorNumeroDeReserva(@PathVariable("numero") String numero) {
        VehiculoReservadoTo vehiculo = this.vehiculoService.buscarVehiculoPorNumeroDeReserva(numero);
        vehiculo.add(linkTo(methodOn(EmpleadoRestfulController.class).buscarVehiculo(vehiculo.getVehiculoId())).withRel("vehiculo"));
        return ResponseEntity.status(HttpStatus.OK).body(vehiculo);
    }
	
	
	//Reservas NICO

	@GetMapping(path = "/reservas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Reserva buscarReserva(@PathVariable("id") Integer id) {
		return this.reservaService.buscar(id);
	}

	@PutMapping(path = "/reservas/{numeroReserva}")
	public void actualizarReserva(@PathVariable("numeroReserva") String numeroReserva) {
		
		Reserva reserva = this.reservaService.buscarPorNumero(numeroReserva);
		reserva.setEstado('E');
		
		Vehiculo v = reserva.getVehiculoReservado();
		v.setEstado("ND");
		reserva.setVehiculoReservado(v);
		
		this.reservaService.actualizar(reserva);
	}

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
	@PutMapping(path = "/clientes", consumes = { MediaType.APPLICATION_JSON_VALUE })
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
