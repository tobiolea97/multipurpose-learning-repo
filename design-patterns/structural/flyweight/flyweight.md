# Patrón Flyweight

El patrón Flyweight es un patrón de diseño estructural que tiene como objetivo minimizar el uso de memoria mediante el compartir tanto como sea posible datos similares entre múltiples objetos. Este patrón es especialmente útil cuando una aplicación necesita crear una gran cantidad de objetos que comparten muchos datos comunes.

El patrón Flyweight funciona separando los datos intrínsecos (que son compartidos) de los datos extrínsecos (que son específicos de cada instancia) y almacenando los datos intrínsecos en un solo lugar para ser reutilizados.

## Beneficios del Patrón Flyweight
1. **Ahorro de Memoria**: Al compartir datos comunes entre objetos, se reduce significativamente el uso de memoria.
2. **Mejora del Rendimiento**: Menos consumo de memoria puede conducir a una mejora en el rendimiento de la aplicación.

## Ejemplo en Java

Aquí tienes un ejemplo simple en Java para ilustrar el uso del patrón Flyweight. Supongamos que estamos creando un programa que dibuja muchos círculos en una pantalla. En lugar de crear una nueva instancia de un círculo para cada posición, podemos reutilizar instancias de círculos con los mismos atributos.

```java
import java.util.HashMap;

// Clase Flyweight que define los datos intrínsecos compartidos
class Circle {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}

// Fábrica de Flyweights que gestiona la creación y el almacenamiento de objetos compartidos
class CircleFactory {
    private static final HashMap<String, Circle> circleMap = new HashMap<>();

    public static Circle getCircle(String color) {
        Circle circle = circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}

// Cliente que utiliza el patrón Flyweight
public class FlyweightPatternDemo {
    private static final String[] colors = { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Circle circle = CircleFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
```