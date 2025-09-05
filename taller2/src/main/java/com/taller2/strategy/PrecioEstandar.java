package com.taller2.strategy;

import java.lang.Override;

public class PrecioEstandar implements EstrategiaPrecio {

    @Override
    public double total(int dias, double costoBase, double seguro) {
        return costoBase * dias + seguro;
    }
}
