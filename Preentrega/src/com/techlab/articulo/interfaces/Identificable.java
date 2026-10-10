package com.techlab.articulo.interfaces;

/**
 * Contrato para los objetos que se identifican con un código numérico.
 * Permite que el Repositorio genérico busque cualquier objeto por su código.
 */
public interface Identificable {

    int getCodigo();
}
