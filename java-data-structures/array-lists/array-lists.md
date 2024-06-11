# Array List

Un ArrayList es una implementación de la interfaz List en Java que utiliza un array redimensionable para almacenar los elementos. A diferencia de los arrays normales, los ArrayList pueden crecer y reducir su tamaño automáticamente cuando se añaden o eliminan elementos.

### Características de ArrayList:
- Tamaño dinámico: Un ArrayList puede crecer y reducirse dinámicamente según sea necesario.
- Acceso rápido: Los ArrayList permiten el acceso rápido a los elementos mediante índices.
- Orden de inserción: Mantienen el orden de inserción de los elementos.
- Elementos duplicados: Permiten elementos duplicados.

### Desventajas de ArrayList:
- Coste de Inserción y Eliminación: Las operaciones de inserción y eliminación pueden ser costosas (O(n)) en términos de tiempo cuando se realizan en el medio del ArrayList, ya que requieren el desplazamiento de los elementos.

- Consumo de Memoria: Aunque los ArrayList se redimensionan automáticamente, pueden ocupar más memoria de la necesaria debido a su capacidad interna, la cual a menudo es mayor que el número de elementos almacenados para minimizar las operaciones de redimensionamiento.
- No es Sincronizado: ArrayList no es sincronizado, lo que significa que no es thread-safe sin medidas adicionales. En aplicaciones multi-hilo, se deben sincronizar explícitamente o usar colecciones sincronizadas como Vector.

- Requiere Contiguidad de Memoria: Internamente, un ArrayList usa un array, lo que requiere un bloque contiguo de memoria. Esto puede ser menos eficiente en términos de manejo de memoria en comparación con otras estructuras de datos como las listas enlazadas.

```java
public class Main {
    public static void main(String[] args) {
        // Crear un nuevo ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Añadir elementos al ArrayList
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);

        // Imprimir el ArrayList
        System.out.println("ArrayList original: " + arrayList);

        // Obtener un elemento por su índice
        int elementAtIndex2 = arrayList.get(2);
        System.out.println("Elemento en el índice 2: " + elementAtIndex2);

        // Modificar un elemento en un índice específico
        arrayList.set(2, 35);
        System.out.println("Después de set(2, 35): " + arrayList);

        // Eliminar un elemento por su índice
        arrayList.remove(2);
        System.out.println("Después de remove(2): " + arrayList);

        // Eliminar un elemento específico
        arrayList.remove(Integer.valueOf(40));
        System.out.println("Después de remove(Integer.valueOf(40)): " + arrayList);

        // Comprobar si el ArrayList contiene un elemento
        boolean contains50 = arrayList.contains(50);
        System.out.println("¿El ArrayList contiene 50? " + contains50);

        // Obtener el tamaño del ArrayList
        int size = arrayList.size();
        System.out.println("Tamaño del ArrayList: " + size);

        // Recorrer el ArrayList
        System.out.print("Recorriendo el ArrayList: ");
        for (int element : arrayList) {
            System.out.print(element + " ");
        }
    }
}
```