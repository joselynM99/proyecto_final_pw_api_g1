package com.proyecto.web.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IGestorReportesService;
import com.proyecto.web.service.to.ClienteVIPTO;
import com.proyecto.web.service.to.ReporteReservasTO;
import com.proyecto.web.service.to.VehiculoVip;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/reportes")
@CrossOrigin
public class ReportesRestfulController {

	@Autowired
	private IGestorReportesService iGestorReportesService;
	
	

	@GetMapping(path = "/VehiculoVip", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<VehiculoVip> vehiculoVip(@RequestParam ("fechaInicio") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fechaInicio){
		Month mes=fechaInicio.getMonth();
		int anio= fechaInicio.getYear();
		
		List<VehiculoVip> listaVehiculoVip= this.iGestorReportesService.reporteVehiculoVip(mes, Year.of(anio));
		return listaVehiculoVip;
	}
	
	
	
	@GetMapping(path = "/clientesVIP", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVIPTO> reporteClientesVIP(){
		
		List<ClienteVIPTO> lista = this.iGestorReportesService.buscarClientesVIP();
		
		for(ClienteVIPTO c: lista) {
		
			Link myLink = linkTo(methodOn(ClienteRestfulController.class).buscarClientePorCedula(c.getCedula())).withSelfRel();
			c.add(myLink);
		}
		
		return lista;
	}
	
	
	@GetMapping(path = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<ReporteReservasTO> reporteReservasFechas(@RequestParam("inicio") String inicio,
			@RequestParam("fin") String fin) {
		return this.iGestorReportesService.reporteReservas(LocalDate.parse(inicio), LocalDate.parse(fin));
	}

}
