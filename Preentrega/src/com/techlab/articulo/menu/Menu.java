package com.techlab.articulo.menu;

import com.techlab.articulo.util.Entrada;

import java.util.Scanner;

/**
 * Clase abstracta base de los menús. Define el ciclo común (mostrar opciones,
 * leer una opción, procesarla y repetir hasta elegir 0) y deja a cada menú
 * concreto el contenido de las opciones.
 */
public abstract class Menu {

    protected final Scanner scanner;

    protected Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Muestra por pantalla las opciones del menú. */
    protected abstract void mostrarOpciones();

    /** Ejecuta la opción elegida (0 = salir del menú). */
    protected abstract void procesarOpcion(int opcion);

    /** Ciclo principal del menú: se repite hasta que el usuario elige 0. */
    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = Entrada.leerEntero(scanner, "Ingrese una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);
    }
}
