# Iterator
El patrón Iterator es un patrón de diseño de comportamiento que permite recorrer los elementos de una colección sin exponer su representación subyacente. Proporciona una forma de acceder secuencialmente a los elementos de un agregado (colección) sin necesidad de conocer su estructura interna.

### Usos del patrón Iterator
- Acceso Secuencial: Permite recorrer una colección de elementos de manera secuencial sin exponer los detalles internos de la colección.
- Diversidad de Estructuras: Funciona con diferentes tipos de colecciones (listas, conjuntos, mapas, etc.) de manera uniforme.
- Simplificación del Código: Separa la lógica de recorrido de la colección de la lógica de la colección misma, simplificando el código.
- Consistencia en el Recorrido: Proporciona una interfaz consistente para recorrer diferentes tipos de colecciones.

### Ejemplo 1

```java
public class Item {

    private final String name;
    private final int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }


    public int getQuantity() {
        return this.quantity;
    }
}

public class Inventory implements Iterable<Item> {

    private final Item[] items;

    public Inventory(Item... items) {
        this.items = items;
    }

    public Item[] getItems() {
        return this.items;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StockIterator(this);
    }

}

public class StockIterator implements Iterator<Item> {

    private Inventory inventory;
    private int index;

    public StockIterator(Inventory inventory) {
        this.inventory = inventory;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        var items = inventory.getItems();
        return index < items.length;
    }

    @Override
    public Item next() {
        var items = inventory.getItems();
        if (hasNext()) {
            var item = items[index++];
            if (item.getQuantity() > 0) {
                return item;
            } else {
                return next();
            }
        } else {
            return null;
        }
    }
}


public class App {

    public static void main(String[] args) {

        var pen = new Item("Pen", 20);
        var pencil = new Item("Pencil", 0);
        var eraser = new Item("Eraser", 15);

        var inventory = new Inventory(pen, pencil, eraser);
        var stockIterator = inventory.iterator();

        while (stockIterator.hasNext()) {
            var item = stockIterator.next();
            System.out.println(item.getName());
        }

    }

}
```

### Ejemplo 1

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}

public class ConcreteIterator<T> implements Iterator<T> {
    private List<T> collection;
    private int position = 0;

    public ConcreteIterator(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return position < collection.size();
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            return collection.get(position++);
        }
        return null;
    }
}

public class ConcreteCollection<T> implements IterableCollection<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(items);
    }
}

public class Main {
    public static void main(String[] args) {
        ConcreteCollection<String> collection = new ConcreteCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}



```