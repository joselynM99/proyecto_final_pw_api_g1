package com.proyecto.web.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
	@SequenceGenerator(name = "seq_reserva", sequenceName = "seq_reserva", allocationSize = 1)
	@Column(name = "rese_id")
	private Integer id;

	@Column(name = "rese_numero")
	private String numero;

	@Column(name = "rese_fecha_inicio", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaInicio;

	@Column(name = "rese_fecha_final", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaFinal;

	@Column(name = "rese_estado")
	private Character estado;

	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente clienteReserva;
	
	@ManyToOne
	@JoinColumn(name = "vehi_id")
	private Vehiculo vehiculoReservado;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pago_id")
	private Pago pagos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDateTime fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Pago getPagos() {
		return pagos;
	}

	public void setPagos(Pago pagos) {
		this.pagos = pagos;
	}

	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public Vehiculo getVehiculoReservado() {
		return vehiculoReservado;
	}

	public void setVehiculoReservado(Vehiculo vehiculoReservado) {
		this.vehiculoReservado = vehiculoReservado;
	}
	
	

}
