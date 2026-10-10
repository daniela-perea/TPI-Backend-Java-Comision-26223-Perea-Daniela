package com.techlab.articulo;

// Importamos Scanner para poder leer datos por teclado desde la consola.
import java.util.Scanner;

// Importamos los dos menús concretos que utilizará la aplicación.
import com.techlab.articulo.menu.MenuArticulos;
import com.techlab.articulo.menu.MenuCategorias;

// Importamos los modelos que administrará el sistema.
import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;

// Importamos el repositorio genérico, que nos permitirá guardar objetos en memoria.
import com.techlab.articulo.repository.Repositorio;

// Importamos la utilidad de lectura de datos.
import com.techlab.articulo.util.Entrada;

/**
 * Clase principal: arma las piezas (repositorios y menús) y mantiene el menú principal.
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Repositorio<Articulo> articulos = new Repositorio<>();
        Repositorio<Categoria> categorias = new Repositorio<>();

        precargarCategorias(categorias);

        MenuArticulos menuArticulos = new MenuArticulos(scanner, articulos, categorias);
        MenuCategorias menuCategorias = new MenuCategorias(scanner, categorias);

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = Entrada.leerEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    menuArticulos.iniciar();
                    break;
                case 2:
                    menuCategorias.iniciar();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Elija una opción del menú.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("SISTEMA DE ARTÍCULOS - CLASE 4 (HERENCIA Y TO_STRING)");
        System.out.println("======================================================");
        System.out.println("1 - Gestionar artículos");
        System.out.println("2 - Gestionar categorías");
        System.out.println("0 - Salir");
        System.out.println("======================================================");
    }

    public static void precargarCategorias(Repositorio<Categoria> categorias) {
        categorias.agregar(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
        categorias.agregar(new Categoria(2, "Periféricos", "Accesorios para computadora"));
        categorias.agregar(new Categoria(3, "Alimentos", "Productos alimenticios"));
        categorias.agregar(new Categoria(4, "Limpieza", "Artículos de limpieza del hogar"));
    }
}
