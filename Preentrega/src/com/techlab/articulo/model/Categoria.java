package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;

/**
 * Representa la categoría a la que pertenece un artículo.
 */
public class Categoria implements Identificable {

    private int codigo;
    private String nombre;
    private String descripcion;

    public Categoria(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria {\n"
                + "codigo=" + codigo + ",\n"
                + "nombre='" + nombre + "',\n"
                + "descripcion='" + descripcion + "'\n"
                + "}";
    }
}
