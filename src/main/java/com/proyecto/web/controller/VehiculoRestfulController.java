package com.proyecto.web.controller;

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

import com.proyecto.web.repository.model.Vehiculo;
import com.proyecto.web.service.IVehiculoService;
import com.proyecto.web.service.to.VehiculoReservadoTo;
import com.proyecto.web.service.to.VehiculoTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin("http://localhost:8080/")
public class VehiculoRestfulController {
    
    @Autowired
    private IVehiculoService vehiculoService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertarVehiculo(@RequestBody VehiculoTO vehiculo) {
        this.vehiculoService.insertar(vehiculo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarVehiculo(@RequestBody Vehiculo vehiculo) {
        this.vehiculoService.actualizar(vehiculo);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminarVehiculo(@PathVariable("id") Integer id) {
        this.vehiculoService.borrar(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehiculo> buscarVehiculo(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.buscar(id));
    }

    @GetMapping(path = "/marca/{marca}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehiculoTO>> buscarVehiculosPorMarca(@PathVariable("marca") String marca) {
        List<VehiculoTO> vehiculoTos = this.vehiculoService.buscarVehiculosPorMarca(marca);
        for (VehiculoTO vehiculoTo : vehiculoTos) {
            Link myLink = linkTo(methodOn(VehiculoRestfulController.class).buscarVehiculo(vehiculoTo.getId())).withSelfRel();
            vehiculoTo.add(myLink);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoTos);
    }

    @GetMapping(path = "/numero/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoReservadoTo> buscarVehiculoPorNumeroDeReserva(@PathVariable("numero") String numero) {
        VehiculoReservadoTo vehiculo = this.vehiculoService.buscarVehiculoPorNumeroDeReserva(numero);
        vehiculo.add(linkTo(methodOn(VehiculoRestfulController.class).buscarVehiculo(vehiculo.getVehiculoId())).withRel("vehiculo"));
        return ResponseEntity.status(HttpStatus.OK).body(vehiculo);
    }
}
