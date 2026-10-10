package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Calculable;
import com.techlab.articulo.interfaces.Identificable;

/**
 * Clase abstracta padre de todos los artículos.
 * Contiene los atributos y comportamientos comunes; las clases hijas
 * deben implementar los métodos abstractos.
 */
public abstract class Articulo implements Identificable, Calculable {

    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Articulo(int codigo, String nombre, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /** Alícuota de IVA aplicada al artículo (21 % por defecto; las hijas pueden redefinirla). */
    protected double getAlicuotaIva() {
        return 0.21;
    }

    /** Implementa Calculable: precio más IVA. */
    @Override
    public double calcularPrecioFinal() {
        return precio * (1 + getAlicuotaIva());
    }

    /** Devuelve el tipo de artículo (lo define cada clase hija). */
    public abstract String getTipoArticulo();

    /** Devuelve información particular de cada tipo de artículo. */
    public abstract String getDetalleEspecifico();

    @Override
    public String toString() {
        return "Articulo {\n"
                + "codigo=" + codigo + ",\n"
                + "nombre='" + nombre + "',\n"
                + "precio=" + precio + ",\n"
                + "categoria='" + categoria.getNombre() + "',\n"
                + "tipo='" + getTipoArticulo() + "',\n"
                + "detalle='" + getDetalleEspecifico() + "'\n"
                + "}";
    }
}
