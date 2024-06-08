# Patrón Proxy

El patrón Proxy es un patrón de diseño estructural que se utiliza para controlar el acceso a otro objeto. Actúa como un intermediario o representante de ese objeto, proporcionando una capa adicional de control. Este patrón se usa en varias situaciones, algunas de las cuales incluyen:

1. **Control de Acceso**: Un proxy puede controlar el acceso a un objeto, permitiendo o denegando operaciones sobre él según ciertas condiciones.
2. **Retraso de Carga**: Un proxy puede diferir la carga de un objeto costoso hasta que sea necesario, mejorando así el rendimiento.
3. **Caché**: Un proxy puede almacenar en caché los resultados de operaciones costosas para evitar repetir cálculos innecesarios.
4. **Control Remoto**: Un proxy puede representar un objeto que reside en una ubicación diferente, como en otro servidor o en la red, permitiendo la comunicación remota.
5. **Monitoreo y Logging**: Un proxy puede interceptar llamadas a un objeto para registrar actividad o monitorear el uso del objeto.

## Ejemplo en Java

Un ejemplo clásico es el uso de un proxy para controlar el acceso a un objeto de base de datos. El proxy puede verificar si el usuario tiene los permisos necesarios antes de permitirle realizar operaciones en la base de datos.

```java
// Interface común para el objeto real y el proxy
public interface Servicio {
    void ejecutar();
}

// Implementación del objeto real
public class ServicioReal implements Servicio {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando el servicio real");
    }
}

// Implementación del proxy
public class ServicioProxy implements Servicio {
    private ServicioReal servicioReal;

    @Override
    public void ejecutar() {
        if (servicioReal == null) {
            servicioReal = new ServicioReal();
        }
        System.out.println("Ejecutando acciones adicionales en el proxy");
        servicioReal.ejecutar();
    }
}

// Cliente que usa el proxy
public class Cliente {
    public static void main(String[] args) {
        Servicio servicio = new ServicioProxy();
        servicio.ejecutar();
    }
}
```