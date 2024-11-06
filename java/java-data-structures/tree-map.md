# Tree map

Un "tree map" es una estructura de datos que organiza la información en un árbol binario de búsqueda. Proporciona un mapa ordenado donde las claves están ordenadas según su orden natural (o según un comparador proporcionado en el momento de la creación del mapa).

## ¿Para qué se utilizan los TreeMap?
Los TreeMap se utilizan cuando se necesita acceso rápido a los datos y también es importante mantener un orden en las claves. Algunas aplicaciones comunes incluyen:

- Almacenamiento de datos ordenados.
- Implementación de algoritmos que requieren datos ordenados.
- Realización de búsquedas, inserciones y eliminaciones eficientes.

## Ventajas de los TreeMap
1. Ordenacion atuomática: Los TreeMap mantienen las claves ordenadas automáticamente.
2. Búsqueda eficiente: Las operaciones de búsqueda, inserción y eliminación tienen un tiempo de ejecución de O(log n).
3. Implementación de interfaces: Los TreeMap implementan las interfaces `NavigableMap` y `SortedMap`, lo que permite realizar operaciones avanzadas como búsquedas por rango y obtener submapas.

## Desventajas de los TreeMap
1. Mayor consumo de memoria: Los TreeMap consumen más memoria
2. Mayor complejidad: La implementación de un TreeMap es más compleja que la de un HashMap.
3. No se permiten claves nulas

## Operaciones comunes en un TreeMap
- `put(key, value)`: Inserta un par clave-valor en el mapa.
- `get(key)`: Obtiene el valor asociado con la clave especificada.
- `remove(key)`: Elimina la clave y su valor asociado del mapa.
- `containsKey(key)`: Verifica si el mapa contiene una clave específica.
- `containsValue(value)`: Verifica si el mapa contiene un valor específico.
- `size()`: Obtiene el número de elementos en el mapa.
- `isEmpty()`: Verifica si el mapa está vacío.
- `clear()`: Elimina todos los elementos del mapa.
- `keySet()`: Obtiene un conjunto de todas las claves en el mapa.
- `values()`: Obtiene una colección de todos los valores en el mapa.
- `entrySet()`: Obtiene un conjunto de pares clave-valor en el mapa.

## Ejemplo de uso de TreeMap en Java
```java
import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {
        // Crear un TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Insertar elementos en el TreeMap
        treeMap.put(1, "Uno");
        treeMap.put(2, "Dos");
        treeMap.put(3, "Tres");
        treeMap.put(4, "Cuatro");

        // Mostrar el TreeMap
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }

        // Obtener el primer y último elemento
        System.out.println("Primera clave: " + treeMap.firstKey());
        System.out.println("Última clave: " + treeMap.lastKey());

        // Submapa de elementos
        System.out.println("Submapa: " + treeMap.subMap(2, 4));

        // Eliminar un elemento
        treeMap.remove(2);
        System.out.println("TreeMap después de eliminar la clave 2: " + treeMap);
    }
}

```