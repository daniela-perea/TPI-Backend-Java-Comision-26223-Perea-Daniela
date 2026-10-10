package com.techlab.articulo.menu;

import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

import java.util.Scanner;

/**
 * Menú de categorías. Las categorías vienen precargadas, por lo que solo se listan.
 */
public class MenuCategorias extends Menu {

    private final Repositorio<Categoria> categorias;

    public MenuCategorias(Scanner scanner, Repositorio<Categoria> categorias) {
        super(scanner);
        this.categorias = categorias;
    }

    @Override
    protected void mostrarOpciones() {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("MENÚ DE CATEGORÍAS");
        System.out.println("======================================================");
        System.out.println("1 - Listar categorías");
        System.out.println("0 - Volver al menú principal");
        System.out.println("======================================================");
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarCategorias();
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Elija una opción del menú.");
        }
    }

    private void listarCategorias() {
        System.out.println();
        System.out.println("--- LISTA DE CATEGORÍAS ---");
        for (Categoria categoria : categorias.listar()) {
            System.out.println(categoria);
        }
    }
}
