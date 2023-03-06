package com.proyecto.web.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pago")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pago")
	@SequenceGenerator(name = "seq_pago", sequenceName = "seq_pago", allocationSize = 1)
	@Column(name = "pago_id")
	private Integer id;

	@Column(name = "pago_valor_subtotal")
	private BigDecimal valorSubTotal;

	@Column(name = "pago_valor_IVA")
	private BigDecimal valorIVA;

	@Column(name = "pago_valor_total_pagar")
	private BigDecimal valorTotalAPagar;

	@Column(name = "pago_fecha_cobro", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaCobro;

	@Column(name = "pago_tarjeta")
	private String tarjeta;

	@OneToOne(mappedBy = "pagos", cascade = CascadeType.ALL)
	private Reserva pagoReserva;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorSubTotal() {
		return valorSubTotal;
	}

	public void setValorSubTotal(BigDecimal valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
	}

	public BigDecimal getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(BigDecimal valorIVA) {
		this.valorIVA = valorIVA;
	}

	public BigDecimal getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(BigDecimal valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

	public LocalDateTime getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(LocalDateTime fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Reserva getPagoReserva() {
		return pagoReserva;
	}

	public void setPagoReserva(Reserva pagoReserva) {
		this.pagoReserva = pagoReserva;
	}
	
	

}
