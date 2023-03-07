package com.proyecto.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IReportesService;
import com.proyecto.web.service.to.ClienteVIPTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/reportes")
@CrossOrigin
public class ReportesControllerRestFul {
	
	@Autowired
	private IReportesService reportesService;
	
	@GetMapping(path = "/clientesVIP", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVIPTO> reporteClientesVIP(){
		
		List<ClienteVIPTO> lista = this.reportesService.buscarClientesVIP();
		
		for(ClienteVIPTO c: lista) {
		
			Link myLink = linkTo(methodOn(ClienteControllerRestFul.class).buscarClientePorCedula(c.getCedula())).withSelfRel();
			c.add(myLink);
		}
		
		return lista;
	}

}
