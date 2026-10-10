# herencia_polimorfismo_tostring – Sistema de Gestión de Artículos

Aplicación de consola en Java (POO: herencia, clases abstractas, polimorfismo, interfaces y toString()).

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

## Compilar y ejecutar (JDK 17+)
```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -Dfile.encoding=UTF-8 -cp out com.techlab.articulo.App
```
En Windows (PowerShell):
```powershell
mkdir out
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -Dfile.encoding=UTF-8 -cp out com.techlab.articulo.App
```
