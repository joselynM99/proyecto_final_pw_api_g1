package com.proyecto.web.service.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResultadoDisponibilidadVehiculoTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estado;
	private BigDecimal valorTotalPagar;
	private LocalDate fechaDisponible;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDate getFechaDisponible() {
		return fechaDisponible;
	}

	public void setFechaDisponible(LocalDate fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

}
