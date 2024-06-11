# Linked List
Las listas enlazadas (linked lists) son una estructura de datos fundamental en informática que se utilizan para implementar colecciones dinámicas de elementos. Algunas de las razones principales para utilizar listas enlazadas son:

#### Inserciones y eliminaciones eficientes:
Las listas enlazadas permiten insertar y eliminar elementos de manera eficiente en cualquier posición, especialmente cuando se trabaja con inserciones y eliminaciones frecuentes al principio o en el medio de la lista. 

#### Tamaño dinámico:
A diferencia de los arreglos (arrays), que tienen un tamaño fijo, las listas enlazadas pueden crecer y reducirse dinámicamente según sea necesario. Esto las hace adecuadas para aplicaciones donde no se conoce el tamaño exacto de la colección de elementos de antemano.

#### Uso eficiente de la memoria:
Las listas enlazadas no necesitan espacio de memoria contiguo para almacenar sus elementos, a diferencia de los arreglos. Esto puede ser ventajoso en situaciones donde la memoria está fragmentada o es difícil de manejar de manera contigua.

#### Implementación de otras estructuras de datos:
Muchas estructuras de datos más complejas, como colas, pilas y grafos, se pueden implementar de manera eficiente utilizando listas enlazadas.

#### Flexibilidad:
Las listas enlazadas permiten fácilmente la implementación de variantes como listas doblemente enlazadas (doubly linked lists), listas circulares (circular linked lists), y otras, que pueden ser útiles para ciertos tipos de algoritmos y aplicaciones.

```java
public class Main {
    public static void main(String[] args) {
        // Crear una nueva LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Añadir elementos a la LinkedList
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        // Imprimir la LinkedList
        System.out.println("LinkedList original: " + linkedList);

        // Añadir un elemento al principio de la LinkedList
        linkedList.addFirst(0);
        System.out.println("Después de addFirst(0): " + linkedList);

        // Añadir un elemento al final de la LinkedList
        linkedList.addLast(6);
        System.out.println("Después de addLast(6): " + linkedList);

        // Obtener el primer y último elemento de la LinkedList
        int firstElement = linkedList.getFirst();
        int lastElement = linkedList.getLast();
        System.out.println("Primer elemento: " + firstElement);
        System.out.println("Último elemento: " + lastElement);

        // Eliminar el primer y último elemento de la LinkedList
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Después de removeFirst() y removeLast(): " + linkedList);

        // Eliminar un elemento específico
        linkedList.remove(Integer.valueOf(3));
        System.out.println("Después de remove(Integer.valueOf(3)): " + linkedList);

        // Recorrer la LinkedList
        System.out.print("Recorriendo la LinkedList: ");
        for (int element : linkedList) {
            System.out.print(element + " ");
        }
    }
}
```