package com.proyecto.web.service.to;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ReservaTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placa;
	private String cedula;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private String tarjeta;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

}
