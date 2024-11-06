# Observer

El patrón de diseño "Observer" es uno de los patrones de comportamiento del catálogo de patrones de diseño de software. Este patrón define una relación de dependencia uno-a-muchos entre objetos, de manera que cuando un objeto cambia su estado, todos sus dependientes son notificados y actualizados automáticamente. Es muy útil para implementar sistemas de eventos y notificaciones.

### Componentes
- Sujeto (Subject): Mantiene una lista de observadores y proporciona métodos para agregar y eliminar observadores. Cuando el estado del sujeto cambia, notifica a todos sus observadores.
- Observador (Observer): Define una interfaz que permite a los objetos ser notificados de los cambios en el sujeto.
- Sujetos Concretos (Concrete Subject): Implementan la funcionalidad específica del sujeto y notifican a los observadores cuando hay un cambio en su estado.
- Observadores Concretos (Concrete Observers): Implementan la interfaz de observador y definen la acción a tomar cuando son notificados de un cambio en el sujeto.

### Ejemplo
``` java
// Interfaz de Observador
public interface Observer {
    void update(float temperature);
}

// Interfaz de Sujeto
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Sujeto Concreto
public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Observador Concreto: Pantalla de Temperatura
public class TemperatureDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Temperatura actual: " + temperature + " grados.");
    }
}

// Observador Concreto: Alarma de Temperatura
public class TemperatureAlarm implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        checkAlarm();
    }

    public void checkAlarm() {
        if (temperature > 30) {
            System.out.println("¡Alarma! Temperatura demasiado alta: " + temperature + " grados.");
        }
    }
}

// Uso del patrón Observer
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureDisplay display = new TemperatureDisplay();
        TemperatureAlarm alarm = new TemperatureAlarm();

        weatherStation.addObserver(display);
        weatherStation.addObserver(alarm);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(35);
    }
}

```