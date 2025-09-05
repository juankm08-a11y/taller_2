package com.taller2.model;

public class Alquiler {
    private Vehiculo vehiculo;
    private int dias;
    private double total;

    public Alquiler(Vehiculo vehiculo, int dias) {
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.total = vehiculo instanceof com.taller2.interfaces.Rentable
                ? ((com.taller2.interfaces.Rentable) vehiculo).calcularPrecioAlquiler(dias)
                : 0;
    }

    public double getTotal() {
        return total;
    }

    public String toString() {
        return "Alquiler de " + vehiculo + " por " + dias + "días. Total: $" + total;
    }
}
