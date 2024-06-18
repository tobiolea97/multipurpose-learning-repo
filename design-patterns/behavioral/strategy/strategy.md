# Strategy
Defines a family of behaviors, puts each of them into separate class, and makes their object interchangeable. Has different implementations that solve the same goal.

En lugar de usar múltiples condicionales (if-else o switch-case) para seleccionar el comportamiento de un algoritmo, el patrón Strategy permite seleccionar el algoritmo apropiado en tiempo de ejecución.

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}

public class ChristmasDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.9; // 10% de descuento
    }
}

public class EasterDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.85; // 15% de descuento
    }
}

public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double price) {
        return discountStrategy.applyDiscount(price);
    }
}

public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        // Usar estrategia de descuento navideño
        calculator.setDiscountStrategy(new ChristmasDiscount());
        System.out.println("Precio con descuento navideño: " + calculator.calculatePrice(100.0));

        // Usar estrategia de descuento de Pascua
        calculator.setDiscountStrategy(new EasterDiscount());
        System.out.println("Precio con descuento de Pascua: " + calculator.calculatePrice(100.0));
    }
}

```