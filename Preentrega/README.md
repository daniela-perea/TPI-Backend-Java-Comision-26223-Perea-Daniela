# TechLab – Sistema de Gestión Comercial (Pre-entrega)

Aplicación de consola en Java para gestionar **productos** y **pedidos**.
Pre-entrega del Trabajo Final Integrador (TFI).

## Introducción

La pre-entrega abarca la primera versión funcional del sistema TechLab. En esta etapa se implementó un menú interactivo en consola que permite manipular el catálogo en memoria y simular el circuito completo de un pedido con validaciones de negocio en tiempo real.

## Objetivos

- Cumplir con los requerimientos funcionales del listado de ejercitación obligatoria (alta, baja, modificación, consulta y pedidos).
- Demostrar el uso correcto de estructuras de control, tipos de datos simples y colecciones de objetos.
- Validar la cohesión modular separando responsabilidades en clases de modelo, gestores de servicios y capa de presentación.
- Implementar herencia y polimorfismo para atender variaciones específicas de productos.

## Funcionalidades Implementadas
- Agregar productos (General, Electro, Comida, Limpieza) con nombre, precio y stock
- Listar productos (ID, categoría, nombre, precio, stock, detalle)
- Buscar por ID o por nombre (parcial) y actualizar precio/stock con validaciones
- Eliminar productos con confirmación
- Crear pedidos con varios productos: valida stock, calcula el total y descuenta stock al confirmar
- Listar pedidos con su costo total y líneas
- Menú interactivo que se repite hasta elegir "Salir"

## Estructura
```
src/com/techlab/articulo/
├── App.java                      (arranque y menú principal)
├── interfaces/
│   ├── Calculable.java
│   └── Identificable.java
├── menu/
│   ├── Menu.java                 (abstracta: ciclo común de los menús)
│   ├── MenuArticulos.java
│   └── MenuCategorias.java
├── model/
│   ├── Articulo.java             (abstracta)
│   ├── ArticuloElectronico.java
│   ├── ArticuloAlimenticio.java
│   ├── ArticuloLimpieza.java
│   └── Categoria.java
├── repository/
│   └── Repositorio.java          (genérico: Repositorio<T extends Identificable>)
└── util/
    └── Entrada.java              (lectura y validación por teclado)
```

## Conceptos aplicados
- **Variables y operadores**: `int`, `double`, `String`, `boolean`; operadores aritméticos (`precio * cantidad`), relacionales (`cantidad > stock`) y lógicos (`||`, `&&`).
- **Colecciones**: `ArrayList<Producto>`, `ArrayList<DetallePedido>`, `ArrayList<Pedido>`.
- **POO**: encapsulamiento (atributos privados + getters/setters validados), herencia (`Bebida`/`Comida` extienden `Producto`), polimorfismo (`getCategoria()`, `getDetalleExtra()` y `toString()` se resuelven según el tipo real), colaboración entre clases (`Pedido` → `DetallePedido` → `Producto`).
- **Excepciones**: `try/catch` con `NumberFormatException`, `IllegalArgumentException` y `DateTimeParseException`; excepciones personalizadas `StockInsuficienteException` y `ProductoNoEncontradoException`.
- **Paquetes**: `com.techlab.productos`, `.pedidos`, `.servicios`, `.excepciones`.

## Herramientas utilizadas
- Lenguaje: Java Standard Edition
- Entorno de Desarrollo: VS Code, Java Extension Pack, Git

---
