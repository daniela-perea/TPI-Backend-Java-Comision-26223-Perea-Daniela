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
├── Preentrega/                              # Código fuente de la primera etapa evaluativa
│   └── src/com/techlab/articulo/
│       ├── App.java                         # Punto de entrada y menú principal por consola
│       │
│       ├── interfaces/                      # Contratos que cumplen las clases del modelo
│       │   ├── Calculable.java              # Cálculo del precio final (con IVA)
│       │   └── Identificable.java           # Objetos identificables por código
│       │
│       ├── model/                           # Modelo de dominio del catálogo
│       │   ├── Articulo.java                # Clase abstracta padre de los artículos
│       │   ├── ArticuloElectronico.java     # Agrega garantía en meses
│       │   ├── ArticuloAlimenticio.java     # Agrega días para el vencimiento
│       │   ├── ArticuloLimpieza.java        # Agrega contenido en mililitros
│       │   └── Categoria.java               # Categoría precargada de los artículos
│       │
│       ├── menu/                            # Interacción con el usuario por consola
│       │   ├── Menu.java                    # Clase abstracta: ciclo común de los menús
│       │   ├── MenuArticulos.java           # Alta, listado, consulta, modificación y baja
│       │   └── MenuCategorias.java          # Listado de categorías
│       │
│       ├── repository/                      # Almacenamiento de objetos en memoria
│       │   └── Repositorio.java             # Genérico: Repositorio<T extends Identificable>
│       │
│       └── util/                            # Utilidades de apoyo
│           └── Entrada.java                 # Lectura y validación de datos por teclado
│
├── EntregaFinal/                                 # Módulo destinado al Trabajo Final Integrador (TFI)
│   └── README.md                            # Espacio reservado para las funcionalidades finales
│
└── README.md                                # Documentación general del repositorio
```

## Herramientas utilizadas
- **Lenguaje:** Java Standard Edition
- **Entorno de Desarrollo:** VS Code, Java Extension Pack, Git
- **Colecciones dinámicas:** ArrayList para la gestión en memoria
- **Control de versión:** Git y GitHub

---
