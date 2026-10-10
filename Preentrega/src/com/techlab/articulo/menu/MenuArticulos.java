package com.techlab.articulo.menu;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloAlimenticio;
import com.techlab.articulo.model.ArticuloElectronico;
import com.techlab.articulo.model.ArticuloLimpieza;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.util.Entrada;

import java.util.Scanner;

/**
 * Menú de artículos: alta, listado, consulta, modificación y baja.
 */
public class MenuArticulos extends Menu {

    private final Repositorio<Articulo> articulos;
    private final Repositorio<Categoria> categorias;

    public MenuArticulos(Scanner scanner,
                         Repositorio<Articulo> articulos,
                         Repositorio<Categoria> categorias) {
        super(scanner);
        this.articulos = articulos;
        this.categorias = categorias;
    }

    @Override
    protected void mostrarOpciones() {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("MENÚ DE ARTÍCULOS");
        System.out.println("======================================================");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar un artículo");
        System.out.println("4 - Modificar un artículo");
        System.out.println("5 - Eliminar un artículo");
        System.out.println("0 - Volver al menú principal");
        System.out.println("======================================================");
    }

    @Override
    protected void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                ingresarArticulo();
                break;
            case 2:
                listarArticulos();
                break;
            case 3:
                consultarArticulo();
                break;
            case 4:
                modificarArticulo();
                break;
            case 5:
                eliminarArticulo();
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Elija una opción del menú.");
        }
    }

    // ===================== FUNCIONALIDADES =====================

    private void ingresarArticulo() {
        System.out.println();
        System.out.println("--- INGRESAR ARTÍCULO ---");
        System.out.println("1 - Artículo electrónico");
        System.out.println("2 - Artículo alimenticio");
        System.out.println("3 - Artículo de limpieza");

        int tipo;
        do {
            tipo = Entrada.leerEntero(scanner, "Seleccione el tipo de artículo: ");
            if (tipo < 1 || tipo > 3) {
                System.out.println("Tipo inválido. Ingrese 1, 2 o 3.");
            }
        } while (tipo < 1 || tipo > 3);

        int codigo = Entrada.leerEnteroNoNegativo(scanner, "Ingrese el código del artículo: ");
        if (articulos.existe(codigo)) {
            System.out.println("Ya existe un artículo con el código " + codigo + ". Ingreso cancelado.");
            return;
        }

        String nombre = Entrada.leerTextoNoVacio(scanner, "Ingrese el nombre del artículo: ");
        double precio = Entrada.leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");

        mostrarCategoriasDisponibles();
        Categoria categoria = pedirCategoriaExistente();

        // Polimorfismo: una variable del tipo padre puede contener cualquier hijo
        Articulo articulo;
        if (tipo == 1) {
            int garantia = Entrada.leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses: ");
            articulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantia);
        } else if (tipo == 2) {
            int dias = Entrada.leerEnteroNoNegativo(scanner, "Ingrese los días para el vencimiento: ");
            articulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, dias);
        } else {
            int contenido = Entrada.leerEnteroNoNegativo(scanner, "Ingrese el contenido en mililitros: ");
            articulo = new ArticuloLimpieza(codigo, nombre, precio, categoria, contenido);
        }

        articulos.agregar(articulo);

        System.out.println("Artículo ingresado correctamente.");
        System.out.println("Resumen del objeto creado:");
        System.out.println(articulo);
    }

    private void listarArticulos() {
        System.out.println();
        System.out.println("--- LISTA DE ARTÍCULOS ---");
        if (articulos.estaVacio()) {
            System.out.println("No hay artículos cargados.");
            return;
        }
        // Java ejecuta el toString() de la clase real de cada objeto
        for (Articulo articulo : articulos.listar()) {
            System.out.println(articulo);
        }
    }

    private void consultarArticulo() {
        System.out.println();
        System.out.println("--- CONSULTAR ARTÍCULO ---");
        if (articulos.estaVacio()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = Entrada.leerEntero(scanner, "Ingrese el código del artículo a consultar: ");
        Articulo articulo = articulos.buscarPorCodigo(codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        System.out.println(articulo);
        System.out.println("Detalle específico: " + articulo.getDetalleEspecifico());
        System.out.printf("Precio final (con IVA): $%.2f%n", articulo.calcularPrecioFinal());

        // Método propio de la subclase: hay que identificar el tipo real
        if (articulo instanceof ArticuloElectronico) {
            ArticuloElectronico electronico = (ArticuloElectronico) articulo;
            System.out.println("Mesa de ayuda para reclamos: "
                    + electronico.nroTelMesaDeAyudaParaReclamos());
        }
    }

    private void modificarArticulo() {
        System.out.println();
        System.out.println("--- MODIFICAR ARTÍCULO ---");
        if (articulos.estaVacio()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = Entrada.leerEntero(scanner, "Ingrese el código del artículo a modificar: ");
        Articulo articulo = articulos.buscarPorCodigo(codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        System.out.println("Datos actuales:");
        System.out.println(articulo);

        // Atributos comunes (el código no se puede modificar)
        String nuevoNombre = Entrada.leerTextoNoVacio(scanner, "Ingrese el nuevo nombre: ");
        double nuevoPrecio = Entrada.leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio: ");
        mostrarCategoriasDisponibles();
        Categoria nuevaCategoria = pedirCategoriaExistente();

        articulo.setNombre(nuevoNombre);
        articulo.setPrecio(nuevoPrecio);
        articulo.setCategoria(nuevaCategoria);

        // Atributo particular según el tipo real
        if (articulo instanceof ArticuloElectronico) {
            ArticuloElectronico electronico = (ArticuloElectronico) articulo;
            int garantia = Entrada.leerEnteroNoNegativo(scanner, "Ingrese la nueva garantía en meses: ");
            electronico.setGarantiaMeses(garantia);
        } else if (articulo instanceof ArticuloAlimenticio) {
            ArticuloAlimenticio alimenticio = (ArticuloAlimenticio) articulo;
            int dias = Entrada.leerEnteroNoNegativo(scanner, "Ingrese los nuevos días para el vencimiento: ");
            alimenticio.setDiasParaVencimiento(dias);
        } else if (articulo instanceof ArticuloLimpieza) {
            ArticuloLimpieza limpieza = (ArticuloLimpieza) articulo;
            int contenido = Entrada.leerEnteroNoNegativo(scanner, "Ingrese el nuevo contenido en mililitros: ");
            limpieza.setContenidoMl(contenido);
        }

        System.out.println("Artículo modificado correctamente.");
    }

    private void eliminarArticulo() {
        System.out.println();
        System.out.println("--- ELIMINAR ARTÍCULO ---");
        if (articulos.estaVacio()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = Entrada.leerEntero(scanner, "Ingrese el código del artículo a eliminar: ");
        Articulo articulo = articulos.buscarPorCodigo(codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        articulos.eliminar(articulo);
        System.out.println("Artículo eliminado correctamente.");
    }

    // ===================== AUXILIARES =====================

    /** Muestra "código - nombre" de cada categoría. */
    private void mostrarCategoriasDisponibles() {
        System.out.println("--- CATEGORÍAS DISPONIBLES ---");
        for (Categoria categoria : categorias.listar()) {
            System.out.println(categoria.getCodigo() + " - " + categoria.getNombre());
        }
    }

    /** Pide un código de categoría hasta que corresponda a una existente. */
    private Categoria pedirCategoriaExistente() {
        Categoria categoria;
        do {
            int codigo = Entrada.leerEntero(scanner, "Ingrese el código de la categoría: ");
            categoria = categorias.buscarPorCodigo(codigo);
            if (categoria == null) {
                System.out.println("La categoría no existe. Intente nuevamente.");
            }
        } while (categoria == null);
        return categoria;
    }
}
