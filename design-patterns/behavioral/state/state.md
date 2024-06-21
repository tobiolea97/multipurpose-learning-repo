# State 

El patrón de diseño "State" es uno de los patrones de comportamiento del catálogo de patrones de diseño de software. Este patrón permite a un objeto cambiar su comportamiento cuando cambia su estado interno. El objeto parecerá cambiar de clase a medida que su estado cambia. Es útil cuando un objeto puede encontrarse en varios estados diferentes, y su comportamiento varía en función del estado en el que se encuentre.

### Componenetes

- Contexto (Context): Es el objeto que tiene un estado interno y cuyo comportamiento cambia según el estado actual. Mantiene una referencia a un objeto de tipo State.
- Estado (State): Define una interfaz común para todos los estados concretos. Cada estado concreto implementa esta interfaz y proporciona un comportamiento específico.
- Estados Concretos (Concrete States): Implementan la interfaz del Estado y definen el comportamiento específico para cada estado.

### Ejemplo 

``` java
// Interfaz de Estado
public interface VendingMachineState {
    void insertCoin(VendingMachine context);
    void selectProduct(VendingMachine context);
    void dispenseProduct(VendingMachine context);
}

// Estado Concreto: Esperando Moneda
public class WaitingForCoinState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine context) {
        System.out.println("Moneda insertada. Seleccione un producto.");
        context.setState(new ProductSelectionState());
    }

    @Override
    public void selectProduct(VendingMachine context) {
        System.out.println("Primero inserte una moneda.");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Primero inserte una moneda.");
    }
}

// Estado Concreto: Seleccionando Producto
public class ProductSelectionState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine context) {
        System.out.println("Ya insertó una moneda. Seleccione un producto.");
    }

    @Override
    public void selectProduct(VendingMachine context) {
        System.out.println("Producto seleccionado. Dispensando producto.");
        context.setState(new DispensingState());
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Primero seleccione un producto.");
    }
}

// Estado Concreto: Dispensando Producto
public class DispensingState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine context) {
        System.out.println("Espere mientras dispensamos su producto.");
    }

    @Override
    public void selectProduct(VendingMachine context) {
        System.out.println("Espere mientras dispensamos su producto.");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Producto dispensado. Puede insertar una nueva moneda.");
        context.setState(new WaitingForCoinState());
    }
}

// Contexto: Máquina Expendedora
public class VendingMachine {
    private VendingMachineState state;

    public VendingMachine() {
        this.state = new WaitingForCoinState();  // Estado inicial
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void selectProduct() {
        state.selectProduct(this);
    }

    public void dispenseProduct() {
        state.dispenseProduct(this);
    }
}

// Uso del patrón State
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();
    }
}

```