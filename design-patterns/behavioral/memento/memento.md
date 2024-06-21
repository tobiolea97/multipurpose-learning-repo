# Memento

El patrón de diseño "Memento" es uno de los patrones de comportamiento del catálogo de patrones de diseño de software. Se utiliza para capturar y externalizar el estado interno de un objeto sin violar su encapsulación, de manera que el objeto pueda ser restaurado a este estado más adelante. Este patrón es particularmente útil en aplicaciones donde es necesario implementar funcionalidad de deshacer (undo) o rehacer (redo).

### Componentes
- Originador: Es el objeto cuyo estado se desea guardar. Tiene métodos para crear un memento de su estado actual y para restaurar su estado desde un memento.
- Memento: Almacena el estado interno del originador. Solo el originador puede acceder al contenido del memento. Generalmente, el memento tiene dos interfaces: una interna (accesible solo para el originador) y otra externa (accesible para otros objetos como el cuidador).
- Cuidador: Es responsable de mantener el memento. No modifica ni inspecciona el contenido del memento, solo lo almacena y lo pasa de vuelta al originador cuando se requiere una restauración

### Ejemplo ChapGPT
``` java
// Memento
public class DrawingMemento {
    private final String drawingState;

    public DrawingMemento(String state) {
        this.drawingState = state;
    }

    public String getState() {
        return drawingState;
    }
}

// Originator
public class Drawing {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public DrawingMemento save() {
        return new DrawingMemento(state);
    }

    public void restore(DrawingMemento memento) {
        this.state = memento.getState();
    }
}

// Caretaker
public class DrawingHistory {
    private Stack<DrawingMemento> history = new Stack<>();

    public void save(Drawing drawing) {
        history.push(drawing.save());
    }

    public void undo(Drawing drawing) {
        if (!history.isEmpty()) {
            drawing.restore(history.pop());
        }
    }
}

// Uso del patrón Memento
public class Main {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        DrawingHistory history = new DrawingHistory();

        drawing.setState("Dibujo 1");
        history.save(drawing);

        drawing.setState("Dibujo 2");
        history.save(drawing);

        drawing.setState("Dibujo 3");
        System.out.println("Estado actual: " + drawing.getState());

        history.undo(drawing);
        System.out.println("Estado después de deshacer: " + drawing.getState());

        history.undo(drawing);
        System.out.println("Estado después de deshacer: " + drawing.getState());
    }
}

```
