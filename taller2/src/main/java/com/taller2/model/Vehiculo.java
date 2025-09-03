package com.taller2.model;

import com.taller2.strategy.EstrategiaPrecio;

public abstract class Vehiculo {

    // Creamos los campos
    private String placa;
    private String marca;
    private String modelo;
    private double km;
    private EstrategiaPrecio estrategiaPrecio;

    // Creamos el constructor vehiculo
    public Vehiculo(String placa, String marca, String modelo, double km) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
    }

    // Creamos nuestro metodo abstracto costoBaseDia
    public abstract double costoBaseDia();

    // Creamos los concretos toString() y sumarKm(double km)

    public void sumarKm(double km) {
        if (km < 0)
            throw new IllegalArgumentException("Los km no pueden ser negativos");
        this.km += km;
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + placa + " - " + marca + " " + modelo + " - km:" + km + "]";
    }

    // Creamos los getters and setters
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
