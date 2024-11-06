# Tree set
Un TreeSet es una implementación de la interfaz NavigableSet y extiende AbstractSet, que utiliza una estructura de árbol rojo-negro internamente para almacenar los elementos. Los elementos en un TreeSet están ordenados de acuerdo a su orden natural (o según un comparador proporcionado en el momento de la creación del conjunto).

## ¿Para qué se utilizan los Tree Set?
Los TreeSet se utilizan cuando se necesita un conjunto ordenado de elementos y se quiere mantener un orden específico de manera automática. Algunas aplicaciones comunes incluyen:

- Almacenamiento de datos únicos y ordenados.
- Implementación de algoritmos que requieren un conjunto ordenado de datos.
- Realización de búsquedas, inserciones y eliminaciones eficientes.

## Ventajas de los Tree Set
1. Ordenación automática: Los elementos se mantienen ordenados automáticamente.
2. No permite duplicados: Garantiza que no haya elementos duplicados en el conjunto.
3. Acceso rápido a datos: Permite búsquedas, inserciones y eliminaciones en tiempo logarítmico O(log n).
4. Navegación eficiente: La interfaz NavigableSet proporciona métodos para navegar por el conjunto (e.g., headSet, tailSet, subSet).

## Desventajas de los Tree Set
1. Complejidad de tiempo: Aunque O(log n) es eficiente, en algunos casos un HashSet puede ser más rápido para  accesos directos con complejidad O(1).
2. Memoria adicional: Puede consumir más memoria que un HashSet debido a la estructura de árbol.
3. No permite elementos nulos: Un TreeSet no permite elementos nulos, a diferencia de un HashSet.

## Operaciones comunes en un Tree Set
- `add(element)`: Añade un elemento al conjunto.
- `remove(element)`: Elimina un elemento del conjunto.
- `contains(element)`: Verifica si el conjunto contiene un elemento específico.
- `size()`: Obtiene el número de elementos en el conjunto.
- `isEmpty()`: Verifica si el conjunto está vacío.
- `clear()`: Elimina todos los elementos del conjunto.
- `first()`: Obtiene el primer elemento del conjunto.
- `last()`: Obtiene el último elemento del conjunto.
- `headSet(toElement)`: Obtiene un subconjunto de elementos menores que el elemento especificado.
- `tailSet(fromElement)`: Obtiene un subconjunto de elementos mayores o iguales al elemento especificado.
- `subSet(fromElement, toElement)`: Obtiene un subconjunto de elementos entre los elementos especificados.

## Ejemplo de uso de TreeSet en Java
```java
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {
    public static void main(String[] args) {
        // Crear un TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Insertar elementos en el TreeSet
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);

        // Mostrar el TreeSet
        System.out.println("Elementos del TreeSet: " + treeSet);

        // Iterar sobre los elementos del TreeSet
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("Elemento: " + iterator.next());
        }

        // Obtener el primer y último elemento
        System.out.println("Primer elemento: " + treeSet.first());
        System.out.println("Último elemento: " + treeSet.last());

        // Subconjunto de elementos
        System.out.println("Subconjunto: " + treeSet.subSet(2, 4));

        // Eliminar un elemento
        treeSet.remove(2);
        System.out.println("TreeSet después de eliminar el elemento 2: " + treeSet);
    }
}
```