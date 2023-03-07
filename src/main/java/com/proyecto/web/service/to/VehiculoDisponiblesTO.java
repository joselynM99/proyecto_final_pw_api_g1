package com.proyecto.web.service.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class VehiculoDisponiblesTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placa;
	private String modelo;
	private String marca;
	private String anioFabricacion;
	private String estado;
	private BigDecimal valorPorDia;

	// get and set
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

}
