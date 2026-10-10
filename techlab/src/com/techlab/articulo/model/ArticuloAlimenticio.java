package com.techlab.articulo.model;

/**
 * Artículo alimenticio: agrega los días restantes para el vencimiento.
 */
public class ArticuloAlimenticio extends Articulo {

    private int diasParaVencimiento;

    public ArticuloAlimenticio(int codigo, String nombre, double precio,
                               Categoria categoria, int diasParaVencimiento) {
        super(codigo, nombre, precio, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento) {
        this.diasParaVencimiento = diasParaVencimiento;
    }

    /** Los alimentos tributan IVA reducido (10,5 %). */
    @Override
    protected double getAlicuotaIva() {
        return 0.105;
    }

    @Override
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Días para vencimiento: " + diasParaVencimiento;
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo alimenticio]";
    }
}
