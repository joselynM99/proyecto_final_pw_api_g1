package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.repository.model.Reserva;
import com.proyecto.web.service.IReservaService;

@RestController
@RequestMapping("/reservas")
@CrossOrigin("http://localhost:8080/")
public class ReservaRestfulController {
    
    @Autowired
    private IReservaService reservaService;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reserva buscarReserva(@PathVariable("id") Integer id) {
        return this.reservaService.buscar(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarReserva(@RequestBody Reserva reserva) {
        this.reservaService.actualizar(reserva);
    }
}
