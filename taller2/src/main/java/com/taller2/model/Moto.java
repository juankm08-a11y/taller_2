package com.taller2.model;

import com.taller2.interfaces.*;
import java.lang.Override;

public class Moto extends Vehiculo implements Rentable {
    public Moto(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }

    @Override
    public double costoBaseDia() {
        return 50;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        if (dias <= 0)
            throw new IllegalArgumentException("Los dias deben ser positivos");
        return getEstrategiaPrecio().total(dias, costoBaseDia(), 0);
    }
}
