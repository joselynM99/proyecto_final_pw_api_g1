package com.proyecto.web.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Cliente;
import com.proyecto.web.modelo.Pago;
import com.proyecto.web.modelo.Reserva;
import com.proyecto.web.repository.IClienteRepository;
import com.proyecto.web.service.to.ClienteVIPTO;

@Service
public class ReportesServiceImpl implements IReportesService {
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public List<ClienteVIPTO> buscarClientesVIP() {

		List<ClienteVIPTO> listaF = new ArrayList<>();

		List<Cliente> clientes = this.clienteRepository.buscarPagosClientes();

		for (Cliente c : clientes) {
			ClienteVIPTO clie = new ClienteVIPTO();
			clie.setApellido(c.getApellido());
			clie.setCedula(c.getCedula());
			clie.setNombre(c.getNombre());

			List<Reserva> reservas = c.getReservas();
			BigDecimal totalIva = new BigDecimal(0);
			BigDecimal valorTotal = new BigDecimal(0);

			for (Reserva r : reservas) {
				Pago pago = r.getPago();

				totalIva = totalIva.add(pago.getValorIVA());
				valorTotal = valorTotal.add(pago.getValorTotalAPagar());
			}

			clie.setValorIVA(totalIva);
			clie.setValorTotal(valorTotal);
			
			listaF.add(clie);

		}

		return listaF.stream()
			    .sorted(Comparator.comparing(ClienteVIPTO::getValorTotal).reversed())
			    .collect(Collectors.toList());
	}

}
