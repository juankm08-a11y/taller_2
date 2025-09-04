package com.taller2.model;

import com.taller2.*;
import com.taller2.interfaces.*;

public class Camioneta extends Vehiculo implements Rentable, Asegurable {
    private double capacidadCarga;

    public Camioneta(String placa, String marca, String modelo, double km, double capacidadCarga) {
        super(placa, marca, modelo, km);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double costoBaseDia() {
        return 150;
    }

    @Override
    public double calcularSeguro(int dias) {
        return dias * 30;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        if (dias <= 0)
            throw new IllegalArgumentException("Los dias deben ser positivos");
        return getEstrategiaPrecio().total(dias, costoBaseDia(), calcularPrecioAlquiler(dias));
    }
}
