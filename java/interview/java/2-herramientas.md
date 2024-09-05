## Reflexion

En Java, la reflexión es una característica que permite inspeccionar y manipular las clases, interfaces, campos y métodos en tiempo de ejecución. Permite:

- Obtener información sobre los campos, métodos y constructores de una clase.
- Invocar métodos en tiempo de ejecución.
- Crear nuevas instancias de clases.
- Acceder y modificar los campos de una clase.

```java
    // Obtener la clase
    Class<?> clase = Class.forName("java.util.ArrayList");

    // Obtener todos los métodos de la clase
    Method[] metodos = clase.getMethods();

    // Imprimir los nombres de los métodos
    for (Method metodo : metodos) {
        System.out.println(metodo.getName());
    }
```

## Generics
Los generics (o generics types) en Java son una característica que permite definir clases, interfaces y métodos con tipos de datos parametrizados. Esto significa que puedes escribir código más flexible y reutilizable, que puede manejar múltiples tipos de datos sin perder la seguridad de tipos en tiempo de compilación.

```java
    // Clase genérica
    public class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    // Crear una instancia de la clase genérica
    Box<Integer> box = new Box<>(10);
    int value = box.getValue();
```


## Strings

- String: es una secuencia de caracteres en Java, que se utiliza para almacenar y manipular texto.
- StringBuilder: es una clase que proporciona una forma eficiente de construir cadenas de caracteres mutables.
- StringBuffer: es similar a StringBuilder, pero es sincronizado y seguro para subprocesos.

## IO

La librería java.io es un paquete en Java que proporciona clases y métodos para realizar operaciones de entrada y salida (I/O) en aplicaciones. Es fundamental para trabajar con flujos de datos (streams), archivos, y otros tipos de entrada/salida.

**IMPORTANTE**
Cierre de recursos: Es crucial cerrar los recursos (como streams y readers) una vez que se han utilizado, para evitar fugas de memoria. Puedes usar try-with-resources para simplificar esto.

### Clases:

1. File: representa un archivo o directorio en el sistema de archivos.

```java
    // Crear un objeto File
    File file = new File("archivo.txt");

    // Verificar si el archivo existe
    if (file.exists()) {
        System.out.println("El archivo existe.");
    } else {
        System.out.println("El archivo no existe.");
    }
```

2. InputStream y OutputStream: 
Son clases abstractas para el manejo de flujos de datos en bytes. InputStream se usa para leer datos (entrada) y OutputStream para escribir datos (salida).
- Subclases comunes:
    - FileInputStream, FileOutputStream para leer/escribir bytes en archivos.
    - BufferedInputStream, BufferedOutputStream para mejorar la eficiencia al usar buffers.


3. Reader y Writer: Clases abstractas para el manejo de flujos de datos en caracteres.
- Subclases comunes:
    - FileReader, FileWriter para leer/escribir caracteres en archivos.
    - BufferedReader, BufferedWriter para lectura/escritura eficiente utilizando buffers.
    - PrintWriter para escribir texto de manera formateada.

4. Serializable: Interfaz que se utiliza para marcar una clase como serializable, lo que significa que sus objetos pueden ser convertidos en una secuencia de bytes y almacenados en un archivo o transmitidos a través de la red.

```java
    // Clase serializable
    public class Persona implements Serializable {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    // Serializar un objeto
    Persona persona = new Persona("Juan", 30);
    try {
        FileOutputStream fileOut = new FileOutputStream("persona.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(persona);
        out.close();
        fileOut.close();
        System.out.println("Objeto serializado en persona.ser");
    } catch (IOException e) {
        e.printStackTrace();
    }
```


5. ObjectInputStream y ObjectOutputStream: Clases que permiten leer y escribir objetos serializados en archivos.

```java
    // Deserializar un objeto
    try {
        FileInputStream fileIn = new FileInputStream("persona.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Persona persona = (Persona) in.readObject();
        in.close();
        fileIn.close();
        System.out.println("Objeto deserializado: " + persona);
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
```


## Preguntas

- ¿Qué son las excepciones en Java? ¿Cómo las manejas?
- ¿Qué es la serialización en Java y por qué es importante?
- ¿Qué es el manejo de errores con try-catch-finally en Java?
- ¿Para que se usa try-with-resources en Java?
- Explica la diferencia entre checked y unchecked exceptions.
- ¿Qué es la programación genérica en Java?


## Anotaciones

¿Qué son las anotaciones en Java? ¿Puedes crear tus propias anotaciones?