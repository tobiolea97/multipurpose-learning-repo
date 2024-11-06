# Priority Queue

La clase PriorityQueue en Java es una implementación de una cola con prioridad, una estructura de datos en la que los elementos se ordenan en función de su prioridad. Los elementos con mayor prioridad se procesan antes que los elementos con menor prioridad.

### Características principales de PriorityQueue:
1. Ordenación de Elementos:
Los elementos se ordenan de acuerdo con su orden natural (definido por la implementación de la interfaz Comparable) o por un Comparator proporcionado al momento de la construcción de la cola.

2. Métodos principales:
    - add(E e): Inserta un elemento en la cola.
    - peek(): Recupera, pero no elimina, el primer elemento de la cola, o devuelve null si - la cola está vacía.
    - poll(): Recupera y elimina el primer elemento de la cola, o devuelve null si la cola está vacía.
    - remove(Object o): Elimina una única instancia del elemento especificado de la cola, si está presente.

### Usos comunes de PriorityQueue:

- Gestión de Tareas: Se puede usar para gestionar tareas en un sistema en el que las tareas tienen diferentes niveles de prioridad. Las tareas con mayor prioridad se ejecutan antes que las de menor prioridad.

- Algoritmos de Caminos Más Cortos: Es utilizada en algoritmos como Dijkstra para encontrar el camino más corto en un grafo, donde se priorizan los vértices con menor coste.

- Procesamiento de Eventos: En simulaciones o sistemas de procesamiento de eventos, los eventos se pueden gestionar en función de su tiempo de ocurrencia.

### Implementación de una PriorityQueue en Java:

```java
public class Main {
    public static void main(String[] args) {
        // Crear una PriorityQueue que usa el orden natural de los elementos
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Agregar elementos a la cola
        queue.add(4);
        queue.add(2);
        queue.add(5);
        queue.add(1);

        // Imprimir elementos en el orden de prioridad
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```