package com.taller2.strategy;

import java.lang.Override;

public class PrecioFinde implements EstrategiaPrecio {
    @Override
    public double total(int dias, double costoBase, double seguro) {
        double total = costoBase * dias * seguro;
        if (dias >= 2)
            total *= 0.9;
        return total;
    }
}
