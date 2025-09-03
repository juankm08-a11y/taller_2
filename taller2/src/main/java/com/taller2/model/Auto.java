package com.taller2.model;

import java.lang.Override;

public class Auto extends Vehiculo {

    public Auto(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }

    @Override
    public double costoBaseDia() {
        return 100;
    }
}
