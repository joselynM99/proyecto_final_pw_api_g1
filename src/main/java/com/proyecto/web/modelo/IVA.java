package com.proyecto.web.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "iva")
public class IVA {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_iva")
	@SequenceGenerator(name = "seq_iva", sequenceName = "seq_iva", allocationSize = 1)
	@Column(name = "iva_id")
	private Integer id;

	@Column(name = "iva_valor")
	private BigDecimal valor;

	// gets and sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
