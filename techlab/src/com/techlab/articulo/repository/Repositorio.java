package com.techlab.articulo.repository;

import com.techlab.articulo.interfaces.Identificable;

import java.util.ArrayList;

/**
 * Repositorio genérico: guarda en memoria objetos de cualquier tipo que sea
 * Identificable (Articulo, Categoria, ...) y permite buscarlos por código.
 *
 * @param <T> tipo de objeto que almacena
 */
public class Repositorio<T extends Identificable> {

    private final ArrayList<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public boolean eliminar(T elemento) {
        return elementos.remove(elemento);
    }

    /** Devuelve el elemento con ese código o null si no existe. */
    public T buscarPorCodigo(int codigo) {
        for (T elemento : elementos) {
            if (elemento.getCodigo() == codigo) {
                return elemento;
            }
        }
        return null;
    }

    public boolean existe(int codigo) {
        return buscarPorCodigo(codigo) != null;
    }

    public ArrayList<T> listar() {
        return elementos;
    }

    public boolean estaVacio() {
        return elementos.isEmpty();
    }
}
