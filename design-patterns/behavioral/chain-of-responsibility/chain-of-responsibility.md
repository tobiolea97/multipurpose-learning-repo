# Chain Of Responsibility

Permite pasar una solicitud a lo largo de una cadena de handlers. Cada handler decide si procesa la solicitud o la pasa al siguiente handler en la cadena.

## Ventajas 
- Desacoplamiento del Emisor y Receptor: El emisor de la solicitud no necesita conocer la clase específica del receptor ni su ubicación. Esto reduce el acoplamiento entre componentes.

- Flexibilidad en el Manejo de Solicitudes: Los manejadores de solicitudes pueden ser añadidos, eliminados o reordenados fácilmente en la cadena.

- Responsabilidad Distribuida: La lógica para manejar la solicitud puede ser distribuida entre varios objetos, cada uno con su propia responsabilidad.

## Desventajas
- Complejidad: Puede ser difícil seguir la cadena de responsabilidad y determinar qué objeto manejará la solicitud.
- Rendimiento: Puede haber un impacto en el rendimiento debido a la necesidad de recorrer la cadena de responsabilidad para encontrar el manejador adecuado.

## Ejemplo
```java
// Interfaz del manejador
public interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(String request);
}

// Implementaciones concretas de los manejadores
public class BasicSupportHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Basic Issue")) {
            System.out.println("BasicSupportHandler is handling the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

public class TechnicalSupportHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Technical Issue")) {
            System.out.println("TechnicalSupportHandler is handling the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

public class AdvancedSupportHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("Advanced Issue")) {
            System.out.println("AdvancedSupportHandler is handling the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Uso del patrón Chain of Responsibility
public class Client {
    public static void main(String[] args) {
        Handler basicSupport = new BasicSupportHandler();
        Handler technicalSupport = new TechnicalSupportHandler();
        Handler advancedSupport = new AdvancedSupportHandler();

        basicSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(advancedSupport);

        basicSupport.handleRequest("Technical Issue");
    }
}
```
