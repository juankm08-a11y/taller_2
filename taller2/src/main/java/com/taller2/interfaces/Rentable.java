package com.taller2.interfaces;

public interface Rentable {

    double calcularPrecioAlquiler(int dias);

    default String condiciones() {
        return "Debe presentar licencia de conduccion vigente y dejar un deposito.";
    }
}
