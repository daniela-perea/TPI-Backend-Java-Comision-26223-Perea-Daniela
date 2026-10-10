# TechLab – Sistema de Gestión Comercial (Pre-entrega)

Aplicación de consola en Java para gestionar **productos** y **pedidos**.
Pre-entrega del Trabajo Final Integrador (TFI).

## Introducción

La pre-entrega abarca la primera versión funcional del sistema TechLab. En esta etapa se implementó un menú interactivo en consola que permite administrar un catálogo de artículos en memoria: registrarlos, listarlos, consultarlos, modificarlos y eliminarlos, asociando cada uno a una categoría precargada y validando los datos ingresados por teclado.

Toda la información se almacena en memoria mientras el programa está en ejecución (sin bases de datos, archivos de persistencia ni interfaz gráfica).

## Objetivos

- Cumplir con los requerimientos funcionales de la consigna obligatoria (alta, consulta, modificación, listado y baja de artículos).
- Demostrar el uso correcto de estructuras de control, tipos de datos simples y colecciones de objetos.
- Aplicar herencia, clases abstractas y polimorfismo para atender las variaciones específicas de cada tipo de artículo.
- Separar responsabilidades en paquetes: contratos (interfaces), modelo de dominio, menús de interacción, repositorio de almacenamiento y utilidades.

## Funcionalidades Implementadas
- Ingresar artículo de tres tipos (electrónico, alimenticio o de limpieza), con código, nombre, precio, categoría y un atributo propio de cada tipo:
    - Electrónico: garantía en meses.
    - Alimenticio: días para el vencimiento.
    - Limpieza: contenido en mililitros.
- Listar artículos: muestra cada objeto con su toString(), que incluye tipo, detalle específico y subtipo.
- Consultar un artículo por código: muestra sus datos, el detalle específico y el precio final con IVA. Para los electrónicos también muestra el teléfono de la mesa de ayuda para reclamos.
- Modificar un artículo: permite cambiar nombre, precio, categoría y el atributo propio de su tipo (el código no se puede modificar).
- Eliminar un artículo por código.
- Listar categorías: las categorías (Electrónica, Periféricos, Alimentos y Limpieza) se precargan al iniciar.
- Menú principal y submenús que se repiten hasta elegir la opción de salir o volver.
- Validaciones: opción de menú inexistente, tipo de artículo inválido, código duplicado, texto vacío, precio negativo o no finito (NaN, Infinity), garantía, días o contenido negativos, categoría inexistente, artículo inexistente, listas vacías y texto ingresado donde se espera un número.

## Estructura
```
MENÚ PRINCIPAL                   MENÚ DE ARTÍCULOS               MENÚ DE CATEGORÍAS
1 - Gestionar artículos          1 - Ingresar artículo           1 - Listar categorías
2 - Gestionar categorías         2 - Listar artículos            0 - Volver al menú principal
0 - Salir                        3 - Consultar un artículo
                                 4 - Modificar un artículo
                                 5 - Eliminar un artículo
                                 0 - Volver al menú principal
```

## Estructura
```
src/com/techlab/articulo/
├── App.java                         # Punto de entrada y menú principal por consola
│
├── interfaces/                      # Contratos que cumplen las clases del modelo
│   ├── Calculable.java              # Cálculo del precio final (con IVA)
│   └── Identificable.java           # Objetos identificables por código
│
├── model/                           # Modelo de dominio del catálogo
│   ├── Articulo.java                # Clase abstracta padre de los artículos
│   ├── ArticuloElectronico.java     # Agrega garantía en meses
│   ├── ArticuloAlimenticio.java     # Agrega días para el vencimiento
│   ├── ArticuloLimpieza.java        # Agrega contenido en mililitros
│   └── Categoria.java               # Categoría precargada de los artículos
│
├── menu/                            # Interacción con el usuario por consola
│   ├── Menu.java                    # Clase abstracta: ciclo común de los menús
│   ├── MenuArticulos.java           # Alta, listado, consulta, modificación y baja
│   └── MenuCategorias.java          # Listado de categorías
│
├── repository/                      # Almacenamiento de objetos en memoria
│   └── Repositorio.java             # Genérico: Repositorio<T extends Identificable>
│
└── util/                            # Utilidades de apoyo
    └── Entrada.java                 # Lectura y validación de datos por teclado
```

## Conceptos aplicados
- **Variables y operadores:** int, double, String y boolean; operadores aritméticos (precio * (1 + alícuota)), relacionales (valor < 0, tipo > 3) y lógicos (||, &&).
- **Estructuras de control:** do-while para los menús, switch para despachar las opciones, if / else if y for-each para recorrer las listas.
- **Colecciones:** ArrayList encapsulado dentro de Repositorio<Articulo> y Repositorio<Categoria>.
- **Encapsulamiento:** atributos privados con getters y setters.
- **Herencia:** ArticuloElectronico, ArticuloAlimenticio y ArticuloLimpieza extienden Articulo y reutilizan sus atributos mediante super(...).
- **Abstracción:** Articulo y Menu son clases abstractas; Articulo declara getTipoArticulo() y getDetalleEspecifico(), que cada hija debe implementar.
- **Polimorfismo:** una única lista de Articulo almacena los tres tipos; toString(), getTipoArticulo(), getDetalleEspecifico() y la alícuota de IVA se resuelven según la clase real del objeto. Se usa instanceof y casting para acceder a métodos y atributos propios de cada subclase.
- **Interfaces:** Identificable (código) y Calculable (precio final), implementadas por el modelo.
- **Genéricos:** Repositorio<T extends Identificable> permite buscar por código cualquier tipo de objeto del modelo.
- **Manejo de errores:** try/catch con NumberFormatException para convertir los datos ingresados, y validaciones que repiten la solicitud hasta obtener un dato correcto.
- **Paquetes:** com.techlab.articulo, .interfaces, .model, .menu, .repository y .util.

### Cómo compilar y ejecutar
```
code
Requiere JDK 17 o superior. Desde la carpeta preentrega/:
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -Dfile.encoding=UTF-8 -cp out com.techlab.articulo.App
```

En Windows (PowerShell):
```
mkdir out
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -Dfile.encoding=UTF-8 -cp out com.techlab.articulo.App
```

## Herramientas utilizadas
- Lenguaje: Java Standard Edition
- Entorno de Desarrollo: VS Code, Java Extension Pack, Git

---
