package com.proyecto.web.service.to;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoReservadoTo extends RepresentationModel<VehiculoReservadoTo> {
    
    private String numero;
    private String placa;
    private String modelo;
    private String estado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;

    private Integer vehiculoId;
    private Integer reservaId;
    
    public VehiculoReservadoTo() {
    }

    public VehiculoReservadoTo(String numero, String placa, String modelo, String estado, LocalDateTime fechaInicio, LocalDateTime fechaFinal, Integer vehiculoId, Integer reservaId) {
        this.numero = numero;
        this.placa = placa;
        this.modelo = modelo;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.vehiculoId = vehiculoId;
        this.reservaId = reservaId;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
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
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
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
    public Integer getVehiculoId() {
        return vehiculoId;
    }
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    public Integer getReservaId() {
        return reservaId;
    }
    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

}
