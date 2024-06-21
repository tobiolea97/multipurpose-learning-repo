# Visitor

El patrón de diseño "Visitor" es uno de los patrones de comportamiento del catálogo de patrones de diseño de software. Se utiliza para separar un algoritmo de la estructura de objetos sobre la cual opera, permitiendo definir nuevas operaciones sin cambiar las clases de los elementos sobre los cuales opera. Este patrón es especialmente útil para agregar funcionalidades a estructuras de datos complejas sin modificar sus clases.

### Componentes
- Visitor: Define una interfaz que declara una visita para cada tipo de elemento concreto.
- Concrete Visitor: Implementa las operaciones definidas en la interfaz del visitante para cada tipo de elemento concreto.
- Element: Define una interfaz que acepta un visitante.
- Concrete Element: Implementa la interfaz de elemento y, típicamente, cada elemento concreto implementa el método accept para permitir que un visitante realice alguna operación sobre él.
- Object Structure: Puede ser una colección o una estructura de objetos que pueden ser visitados. Mantiene una colección de elementos y puede iterar sobre ellos para permitir que un visitante los visite.

### Ejemplo
``` java
public interface VehiclePartVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
}


public class Wheel implements VehiclePart {
    private String name;

    public Wheel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(VehiclePartVisitor visitor) {
        visitor.visit(this);
    }
}

public class Engine implements VehiclePart {
    @Override
    public void accept(VehiclePartVisitor visitor) {
        visitor.visit(this);
    }
}

public class Body implements VehiclePart {
    @Override
    public void accept(VehiclePartVisitor visitor) {
        visitor.visit(this);
    }
}

public interface VehiclePart {
    void accept(VehiclePartVisitor visitor);
}

public class VehiclePartDisplayVisitor implements VehiclePartVisitor {
    @Override
    public void visit(Wheel wheel) {
        System.out.println("Displaying " + wheel.getName() + " wheel.");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Displaying engine.");
    }

    @Override
    public void visit(Body body) {
        System.out.println("Displaying body.");
    }
}

public class Main {
    public static void main(String[] args) {
        VehiclePart wheel1 = new Wheel("Front left");
        VehiclePart wheel2 = new Wheel("Front right");
        VehiclePart engine = new Engine();
        VehiclePart body = new Body();

        VehiclePartVisitor displayVisitor = new VehiclePartDisplayVisitor();

        wheel1.accept(displayVisitor);
        wheel2.accept(displayVisitor);
        engine.accept(displayVisitor);
        body.accept(displayVisitor);
    }
}


```