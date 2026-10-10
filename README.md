# TechLab – Sistema de Gestión Comercial

Aplicación de consola desarrollada en Java orientada a la **gestión integral de inventario** y **procesamiento de pedidos para una empresa comercial.** Este sistema constituye el proyecto principal de la cursada y sienta la arquitectura base sobre la cual se incorporarán módulos avanzados en las siguientes etapas.

## Introducción

En el contexto operativo de TechLab, la precisión en la trazabilidad de productos y el control del inventario resultan clave. Esta solución centraliza la administración de artículos mediante una interfaz interactiva por consola, garantizando la consistencia del stock ante cada transacción de compra y minimizando inconsistencias operativas.

## Objetivos

**Centralizar el catálogo de productos:** Permitir la creación, consulta, edición y baja (ABM) de ítems generalizados y especializados.
- **Automatizar el flujo de venta:** Registrar pedidos dinámicos calculando costos totales y descontando el stock disponible en tiempo real.
- **Asegurar la integridad de los datos:** Validar entradas de usuario y lanzar excepciones ante operaciones no permitidas (ej. stock insuficiente).
- **Implementar buenas prácticas de diseño:** Aplicar principios de Programación Orientada a Objetos (POO) y organización modular del código.

## Funcionalidades Implementadas
- Agregar productos (General, Bebida, Comida) con nombre, precio y stock
- Listar productos (ID, categoría, nombre, precio, stock, detalle)
- Buscar por ID o por nombre (parcial) y actualizar precio/stock con validaciones
- Eliminar productos con confirmación
- Crear pedidos con varios productos: valida stock, calcula el total y descuenta stock al confirmar
- Listar pedidos con su costo total y líneas
- Menú interactivo que se repite hasta elegir "Salir"

## Estructura
```text
techlab/
├── preentrega/                         # Código fuente de la primera etapa evaluativa
│   └── src/com/techlab/
│       ├── App.java                    # Punto de entrada y menú por consola
│       ├── productos/                  # Modelo de dominio del catálogo
│       │   ├── Producto.java
│       │   ├── Bebida.java
│       │   └── Comida.java
│       ├── pedidos/                    # Modelo de dominio de compras
│       │   ├── Pedido.java
│       │   └── DetallePedido.java
│       ├── servicios/                  # Capa de lógica de negocio
│       │   ├── GestorProducto.java
│       │   └── GestorPedido.java
│       └── excepciones/                # Excepciones de negocio personalizadas
│           ├── StockInsuficienteException.java
│           └── ProductoNoEncontradoException.java
│
├── entrega/                            # Módulo destinado al Trabajo Final Integrador (TFI)
│   └── README.md                       # Espacio reservado para las funcionalidades finales
│
└── README.md                           # Documentación general del repositorio
```

## Herramientas utilizadas
- **Lenguaje:** Java Standard Edition
- **Entorno de Desarrollo:** VS Code, Java Extension Pack, Git
- **Colecciones dinámicas:** ArrayList para la gestión en memoria
- **Control de versión:** Git y GitHub

---
