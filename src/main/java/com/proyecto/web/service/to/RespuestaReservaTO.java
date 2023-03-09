package com.proyecto.web.service.to;

import java.io.Serializable;

public class RespuestaReservaTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroReserva;

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
}
