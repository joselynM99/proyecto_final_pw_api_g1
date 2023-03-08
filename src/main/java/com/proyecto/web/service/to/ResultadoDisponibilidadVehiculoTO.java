package com.proyecto.web.service.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResultadoDisponibilidadVehiculoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estado;
	private BigDecimal valorTotalPagar;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorTotalPagar() {
		return valorTotalPagar;
	}

	public void setValorTotalPagar(BigDecimal valorTotalPagar) {
		this.valorTotalPagar = valorTotalPagar;
	}


}
