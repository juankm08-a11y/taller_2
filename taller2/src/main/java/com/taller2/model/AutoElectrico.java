package com.taller2.model;

import java.lang.Override;

import com.taller2.interfaces.Electrico;
import java.lang.Math;

public class AutoElectrico extends Auto implements Electrico {
    private int bateria = 50;

    public AutoElectrico(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }

    @Override
    public void recargar(int minutos) {
        bateria = Math.min(100, bateria + minutos / 2);
    }

    @Override
    public int nivelBateria() {
        return bateria;
    }
}
