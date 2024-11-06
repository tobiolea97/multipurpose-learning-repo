# Template method

El patrón de diseño "Template Method" es uno de los patrones de comportamiento del catálogo de patrones de diseño de software. Este patrón define el esqueleto de un algoritmo en una operación, delegando algunos pasos a las subclases. Permite a las subclases redefinir ciertos pasos de un algoritmo sin cambiar la estructura del algoritmo en sí.

### Componentes

- Clase Abstracta (Abstract Class): Define el esqueleto del algoritmo en el método plantilla (template method). Este método llama a otros métodos que pueden ser abstractos o tener una implementación por defecto.
- Método Plantilla (Template Method): Un método definido en la clase abstracta que establece la estructura del algoritmo. Este método puede llamar a métodos abstractos que deben ser implementados por las subclases.
- Métodos Abstractos (Abstract Methods): Métodos que deben ser implementados por las subclases para completar los pasos específicos del algoritmo.
- Subclases Concretas (Concrete Subclasses): Implementan los métodos abstractos definidos en la clase abstracta para proporcionar el comportamiento específico de los pasos del algoritmo.

### Ejemplo

``` java
// Clase Abstracta
public abstract class DocumentProcessor {
    // Método plantilla
    public final void processDocument() {
        openDocument();
        parseDocument();
        closeDocument();
    }

    // Métodos abstractos
    protected abstract void openDocument();
    protected abstract void parseDocument();

    // Método con implementación por defecto
    protected void closeDocument() {
        System.out.println("Cerrando el documento.");
    }
}

// Subclase Concreta: Procesador de PDF
public class PDFProcessor extends DocumentProcessor {
    @Override
    protected void openDocument() {
        System.out.println("Abriendo documento PDF.");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parseando contenido del PDF.");
    }
}

// Subclase Concreta: Procesador de Word
public class WordProcessor extends DocumentProcessor {
    @Override
    protected void openDocument() {
        System.out.println("Abriendo documento Word.");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parseando contenido del Word.");
    }
}

// Uso del patrón Template Method
public class Main {
    public static void main(String[] args) {
        DocumentProcessor pdfProcessor = new PDFProcessor();
        pdfProcessor.processDocument();

        System.out.println();

        DocumentProcessor wordProcessor = new WordProcessor();
        wordProcessor.processDocument();
    }
}
```