package com.proyecto.web.service.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReporteReservasTO {

	// 5 de reserva
	private Integer id;

	private String numero;

	private LocalDate fechaInicio;

	private LocalDate fechaFinal;

	private String estado;

	// 2 de clientes

	private String apellido;

	private String cedula;

	// 3 de vehiculos
	private String placa;

	private String marca;

	private BigDecimal valorPorDia;

	public ReporteReservasTO() {
	}

	public ReporteReservasTO(Integer id, String numero, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			Character estado, String apellido, String cedula, String placa, String marca, BigDecimal valorPorDia) {
		this.numero = numero;
		this.fechaInicio = fechaInicio.toLocalDate();
		this.fechaFinal = fechaFinal.toLocalDate();
		this.estado = (estado=='G')?"Generada":"Ejecutada";
		this.id = id;
		this.apellido = apellido;
		this.cedula = cedula;
		this.placa = placa;
		this.marca = marca;
		this.valorPorDia = valorPorDia;
	}

	// gets and sets
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

}
