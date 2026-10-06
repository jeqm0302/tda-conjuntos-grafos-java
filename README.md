# TDA Conjuntos y Grafos en Java

Implementación de Tipos de Datos Abstractos (TDA) en Java: un **Conjunto** y un **Grafo dirigido y ponderado**, este último con dos representaciones distintas detrás de una misma interfaz.

Proyecto de la materia Programación II (UADE).

## Qué incluye

| TDA | Interfaz | Implementación | Estructura interna |
|-----|----------|----------------|--------------------|
| Conjunto | `ConjuntoTDA` | `ConjuntoLD` | Lista simplemente enlazada de nodos |
| Grafo | `GrafosTDA` | `GrafoMA` | Matriz de adyacencia + arreglo de etiquetas |
| Grafo | `GrafosTDA` | `GrafosLD` | Lista de vértices, cada uno con su lista de aristas |

## Decisiones de diseño

- **Programación contra interfaces:** el código cliente depende de `GrafosTDA` y `ConjuntoTDA`, no de la implementación. Cambiar de `GrafoMA` a `GrafosLD` no requiere tocar nada más.
- **Dos implementaciones del mismo TDA** para comparar costos:
  - `GrafoMA`: acceso a una arista en O(1), pero memoria O(n²) y capacidad fija (55 vértices).
  - `GrafosLD`: memoria proporcional a vértices + aristas y sin límite fijo, pero buscar una arista cuesta O(grado del vértice).
- **Conjunto sin repetidos:** `agregar` verifica pertenencia antes de insertar.
- `vertices()` devuelve un `ConjuntoTDA`, reutilizando el TDA Conjunto dentro del Grafo.

## Operaciones

**Conjunto:** `inicializarConjunto`, `agregar`, `sacar`, `elegir`, `pertenece`, `conjuntoVacío`

**Grafo:** `inicializarGrafo`, `agregarVertice`, `eliminarVertice`, `vertices`, `agregarArista`, `eliminarArista`, `existeArista`, `pesoArista`

Las precondiciones de cada operación están documentadas como comentarios en `GrafosTDA.java`.

## Cómo ejecutarlo

Requiere JDK 11 o superior.

```bash
git clone https://github.com/jeqm0302/tda-conjuntos-grafos-java.git
cd tda-conjuntos-grafos-java
javac -d bin src/Interfaces/*.java src/Implementaciones/*.java src/Main.java
java -cp bin Main
```

## Estructura

```
src/
├── Interfaces/
│   ├── ConjuntoTDA.java
│   └── GrafosTDA.java
├── Implementaciones/
│   ├── ConjuntoLD.java
│   ├── GrafoMA.java
│   └── GrafosLD.java
└── Main.java
```

## Limitaciones conocidas

- `GrafoMA` tiene capacidad fija de 55 vértices.
- Las operaciones asumen sus precondiciones (por ejemplo, `elegir()` sobre un conjunto vacío no está contemplado), como es habitual en la definición clásica de TDA.

## Autor

**Jesús Enrique Quijada Martínez** · Estudiante de Ingeniería en Informática, UADE
[LinkedIn](https://linkedin.com/in/jesúsenrique-quijada-martínez-57b70922b) · [GitHub](https://github.com/jeqm0302)

