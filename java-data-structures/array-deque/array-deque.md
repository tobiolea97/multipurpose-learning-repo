 # Array Deque
 ArrayDeque es una implementación de una cola doblemente terminada (deque, double ended queue), lo que significa que permite la inserción y eliminación de elementos desde ambos extremos (frente y final). Internamente, utiliza una matriz (array) para almacenar los elementos.

## Características de ArrayDeque
- Resizing automático: La capacidad de ArrayDeque se ajusta automáticamente a medida que se añaden o eliminan elementos, aunque es más eficiente cuando se conoce de antemano la capacidad necesaria.
- Sin capacidad fija: A diferencia de ArrayBlockingQueue, ArrayDeque no tiene una capacidad fija.
- No sincronizado: No está sincronizado, lo que significa que no es seguro para el uso en entornos multi-hilo sin la ayuda de una sincronización externa.
- Eficiencia: Operaciones como añadir o eliminar elementos en el frente o el final son de tiempo constante (O(1)) en la mayoría de los casos.

## Uso de ArrayDeque
Se usa principalmente cuando necesitas una estructura de datos que permita operaciones eficientes de inserción y eliminación en ambos extremos. Aquí algunos ejemplos de uso:

### Implementación de una pila
```java
ArrayDeque<Integer> stack = new ArrayDeque<>();
stack.push(1);  // Apilar (push)
stack.push(2);
int top = stack.pop();  // Desapilar (pop)
```

### Implementación de una cola
```java
ArrayDeque<Integer> queue = new ArrayDeque<>();
queue.add(1);  // Encolar (add)
queue.add(2);
int front = queue.remove();  // Desencolar (remove)
```

### Deques
```java
ArrayDeque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);  // Añadir al frente
deque.addLast(2);   // Añadir al final
int first = deque.removeFirst();  // Eliminar del frente
int last = deque.removeLast();    // Eliminar del final
```

### Ejemplo completo
```java
import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        // Añadir elementos
        deque.add("A");
        deque.addFirst("B");
        deque.addLast("C");
        
        // Ver elementos
        System.out.println("First: " + deque.getFirst()); // B
        System.out.println("Last: " + deque.getLast());   // C
        
        // Eliminar elementos
        deque.removeFirst(); // Elimina "B"
        deque.removeLast();  // Elimina "C"
        
        // Mostrar elementos restantes
        System.out.println("Remaining: " + deque); // A
    }
}
```