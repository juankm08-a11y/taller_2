package com.taller2.model;

import java.lang.Override;

import com.taller2.interfaces.*;

public class Auto extends Vehiculo implements Rentable, Asegurable {

    public Auto(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }

    @Override
    public double costoBaseDia() {
        return 100;
    }

    @Override
    public double calcularSeguro(int dias) {
        return dias * 20;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        if (dias <= 0)
            throw new IllegalArgumentException("Los dias deben ser positivos");
        double base = costoBaseDia() * dias + calcularSeguro(dias);
        return getEstrategiaPrecio().total(dias, costoBaseDia(), calcularSeguro(dias));
    }
}
