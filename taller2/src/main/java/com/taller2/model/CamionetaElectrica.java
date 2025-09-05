package com.taller2.model;

import java.lang.Override;

import com.taller2.interfaces.Electrico;
import java.lang.Math;

public class CamionetaElectrica extends Camioneta implements Electrico {
    private int bateria = 60;

    public CamionetaElectrica(String placa, String marca, String modelo, double km, double capacidadCarga) {
        super(placa, marca, modelo, km, capacidadCarga);
    }

    @Override
    public void recargar(int minutos) {
        if (minutos <= 0)
            throw new IllegalArgumentException("Los minutos deben ser positivos");
        int incremento = minutos / 2;
        bateria = Math.min(100, bateria + incremento);
    }

    @Override
    public int nivelBateria() {
        return bateria;
    }
}
