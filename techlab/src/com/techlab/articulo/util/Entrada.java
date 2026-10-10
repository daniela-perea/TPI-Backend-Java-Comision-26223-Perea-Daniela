package com.techlab.articulo.util;

import java.util.Scanner;

/**
 * Métodos de ayuda para leer y validar datos ingresados por teclado.
 */
public class Entrada {

    private Entrada() {
        // Clase utilitaria: no se instancia
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Ingrese un número entero.");
            }
        }
    }

    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje) {
        int valor;
        do {
            valor = leerEntero(scanner, mensaje);
            if (valor < 0) {
                System.out.println("El valor no puede ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }

    public static double leerDoubleNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                // Se acepta tanto 1500.50 como 1500,50
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                    System.out.println("Valor no válido. Ingrese un número finito.");
                } else if (valor < 0) {
                    System.out.println("El valor no puede ser negativo.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Ingrese un número (ej: 1500.50).");
            }
        }
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }
}
