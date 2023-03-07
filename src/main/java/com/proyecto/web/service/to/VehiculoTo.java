package com.proyecto.web.service.to;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import com.proyecto.web.modelo.Vehiculo;

public class VehiculoTo extends RepresentationModel<VehiculoTo> {

    private Integer id;
    private String placa;
    private String modelo;
    private String marca;
    private String anioFabricacion;
    private String pais;
    private String cilindraje;
    private BigDecimal avaluo;
    private BigDecimal valorPorDia;
    private String estado;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }
    public BigDecimal getAvaluo() {
        return avaluo;
    }
    public void setAvaluo(BigDecimal avaluo) {
        this.avaluo = avaluo;
    }
    public BigDecimal getValorPorDia() {
        return valorPorDia;
    }
    public void setValorPorDia(BigDecimal valorPorDia) {
        this.valorPorDia = valorPorDia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Vehiculo toVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(this.id);
        vehiculo.setPlaca(this.placa);
        vehiculo.setModelo(this.modelo);
        vehiculo.setMarca(this.marca);
        vehiculo.setAnioFabricacion(this.anioFabricacion);
        vehiculo.setPais(this.pais);
        vehiculo.setCilindraje(this.cilindraje);
        vehiculo.setAvaluo(this.avaluo);
        vehiculo.setValorPorDia(this.valorPorDia);
        vehiculo.setEstado(this.estado);
        return vehiculo;
    }
}
