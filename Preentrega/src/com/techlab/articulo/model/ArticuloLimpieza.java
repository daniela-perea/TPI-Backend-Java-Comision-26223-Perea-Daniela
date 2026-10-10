package com.techlab.articulo.model;

/**
 * Artículo de limpieza: agrega el contenido del envase en mililitros.
 */
public class ArticuloLimpieza extends Articulo {

    private int contenidoMl;

    public ArticuloLimpieza(int codigo, String nombre, double precio,
                            Categoria categoria, int contenidoMl) {
        super(codigo, nombre, precio, categoria);
        this.contenidoMl = contenidoMl;
    }

    public int getContenidoMl() {
        return contenidoMl;
    }

    public void setContenidoMl(int contenidoMl) {
        this.contenidoMl = contenidoMl;
    }

    @Override
    public String getTipoArticulo() {
        return "Limpieza";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Contenido: " + contenidoMl + " ml";
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo limpieza]";
    }
}
