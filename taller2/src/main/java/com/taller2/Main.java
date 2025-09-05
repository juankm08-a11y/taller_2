package com.taller2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.taller2.model.*;
import com.taller2.interfaces.*;
import com.taller2.strategy.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("ABC123", "Toyota", "Corolla", 10000));
        vehiculos.add(new Moto("XYZ789", "Honda", "CBR500", 10000));
        vehiculos.add(new Camioneta("AJKL456", "Ford", "Ranger", 10000, 1500));
        vehiculos.add(new AutoElectrico("ELE001", "Tesla", "Model 3", 3000));
        vehiculos.add(new CamionetaElectrica("ELE002", "Rivian", "R1T", 5000, 2000));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU DE ALQUILER DE VEHICULOS");
            System.out.println("1.Listar Vehiculos");
            System.out.println("2.Asignar estrategia de precio");
            System.out.println("3.Simular alquiler");
            System.out.println("4.Recargar vehiculo electrico");
            System.out.println("5.Salir");
            System.out.print("Seleccione una opcion");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    listarVehiculos(vehiculos);
                    break;
                case 2:
                    asignarEstrategia(vehiculos);
                    break;
                case 3:
                    simularAlquiler(vehiculos);
                    break;
                case 4:
                    recargarElectrico(vehiculos);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por usar el sistema");
                    break;

                default:
                    System.out.println("Opcion invalidad intente de nuevo");
                    break;
            }
        }
    }

    private static void listarVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("\n-- Lista de Vehiculos");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            System.out.println((i + 1) + ". " + v);
            if (v instanceof Rentable)
                System.out.print("| Rentable");
            if (v instanceof Asegurable)
                System.out.print("| Asegurable");
            if (v instanceof Electrico)
                System.out.print("| Electrico");
            if (v.getEstrategiaPrecio() != null)
                System.out.print("| Estrategia: " + v.getEstrategiaPrecio().getClass().getSimpleName());
            else
                System.out.print("| Estrategia: No asignada");
        }
    }

    private static void asignarEstrategia(List<Vehiculo> vehiculos) {
        listarVehiculos(vehiculos);
        System.out.println("\n-- Seleccione el numero del vehiculo para asignar estrategia: ");
        int index = leerEntero() - 1;

        if (index < 0 || index >= vehiculos.size()) {
            System.out.println("Numero invalido");
            return;
        }

        int opcion = leerEntero();
        EstrategiaPrecio estrategia = null;

        switch (opcion) {
            case 1:
                estrategia = new PrecioEstandar();
                break;
            case 2:
                estrategia = new PrecioFinde();
                break;
            case 3:
                estrategia = new PrecioLargoPlazo();
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }

        vehiculos.get(index).setEstrategiaPrecio(estrategia);
        System.out.println("Estrategia asignada correctamente.");
    }

    private static void simularAlquiler(List<Vehiculo> vehiculos) {
        listarVehiculos(vehiculos);
        System.out.print("\nSeleccione el número del vehiculo para alquiler: ");
        int index = leerEntero() - 1;

        if (index < 0 || index >= vehiculos.size()) {
            System.out.print("Numero invalido");
        }

        Vehiculo v = vehiculos.get(index);

        if (v.getEstrategiaPrecio() == null) {
            System.out.print("Este vehiculo no tiene estrategia de precio asignada.");
            return;
        }

        System.out.print("Ingrsee la cantidad de dias de alquiler: ");
        int dias = leerEntero();

        if (dias <= 0) {
            System.out.print("Los dias deben ser mayores que 0.");
            return;
        }

        if (!(v instanceof Rentable)) {
            System.out.print("Este vehiculo no es alquilable.");
            return;
        }

        double total = ((Rentable) v).calcularPrecioAlquiler(dias);

        System.out.println("Dias: " + dias);
        System.out.println("Total a pagar: $" + total);

    }

    private static void recargarElectrico(List<Vehiculo> vehiculos) {
        listarVehiculos(vehiculos);
        System.out.print("\nSeleccione el numero del vehiculo electrico");
        int index = leerEntero() - 1;

        if (index <= 0 || index >= vehiculos.size()) {
            System.out.print("Numero invalido");
            return;
        }

        Vehiculo v = vehiculos.get(index);

        if (!(v instanceof Electrico)) {
            System.out.print("Este vehiculo no es electrico");
            return;
        }

        Electrico e = (Electrico) v;
        System.out.println("Nivel actual de bateria: " + e.nivelBateria() + "%");
        System.out.print("Ingrese minutos de recarga:");
        int minutos = leerEntero();

        if (minutos <= 0) {
            System.out.println("Los minutos deben ser positivos");
            return;
        }

        e.recargar(minutos);
        System.out.println("Nueva bateria: " + e.nivelBateria() + "%");
    }

    private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalidad, ingrese un numero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}