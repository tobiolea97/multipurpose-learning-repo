# Command

Convierte una solicitud o un comportamiento en un objeto que contiene todo lo que esa solicitud o comportamiento necesita. Encapsula la información necesaria para realizar o disparar un evento o una tarea

## Usos
Se utiliza para encapsular una solicitud como un objeto, lo que permite parametrizar a los clientes con diferentes solicitudes, encolar o registrar solicitudes, y soportar operaciones que pueden deshacerse. Aquí están los usos principales del patrón Command:

- Desacoplamiento del emisor y el receptor: Separa al objeto que invoca la operación (emisor) del objeto que realiza la operación (receptor). Esto permite cambiar el emisor o el receptor de manera independiente.
- Cola de comandos: Permite poner en cola operaciones, lo que es útil para tareas que necesitan ejecutarse en un orden específico o en diferido.
- Registro de comandos: Facilita el registro de las operaciones realizadas, permitiendo así la implementación de funciones como deshacer (undo) y rehacer (redo).
- Parámetros dinámicos: Las solicitudes se pueden parametrizar de manera que el cliente puede cambiar los parámetros de la operación en tiempo de ejecución.
- Macrocomandos: Permite agrupar una serie de comandos en uno solo, facilitando la ejecución de secuencias de operaciones complejas.

```java
// Interface Command
public interface Command {
    void execute();
    void undo();
}

// Implementaciones concretas de comandos
public class WriteCommand implements Command {
    private Document document;
    private String text;

    public WriteCommand(Document document, String text) {
        this.document = document;
        this.text = text;
    }

    @Override
    public void execute() {
        document.write(text);
    }

    @Override
    public void undo() {
        document.erase(text);
    }
}

// Receptor
public class Document {
    public void write(String text) {
        // lógica para escribir texto
    }

    public void erase(String text) {
        // lógica para borrar texto
    }
}

// Invoker
public class TextEditor {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void undoCommand() {
        command.undo();
    }
}

```