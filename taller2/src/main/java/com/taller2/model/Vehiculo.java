package com.taller2.model;

import com.taller2.strategy.EstrategiaPrecio;

public abstract class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private double km;
    private EstrategiaPrecio estrategiaPrecio;

    public Vehiculo(String placa, String marca, String modelo, double km) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
    }

    public abstract double costoBaseDia();

    public void sumarKm(double km) {
        if (km < 0)
            throw new IllegalArgumentException("Los km no pueden ser negativos");
        this.km += km;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + placa + " - " + marca + " " + modelo + " - km:" + km + "]";
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public EstrategiaPrecio getEstrategiaPrecio() {
        return estrategiaPrecio;
    }

    public void setEstrategiaPrecio(EstrategiaPrecio estrategiaPrecio) {
        this.estrategiaPrecio = estrategiaPrecio;
    }

}
