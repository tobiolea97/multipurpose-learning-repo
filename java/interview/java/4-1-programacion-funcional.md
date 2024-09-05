La programación funcional en Java es un paradigma de programación que se basa en el __uso de funciones puras__ (aquellas que no tienen efectos secundarios y siempre devuelven el mismo resultado para los mismos argumentos), la __inmutabilidad de los datos__ y la utilización de __funciones como ciudadanos de primera clase__ (es decir, las funciones pueden ser pasadas como argumentos, devueltas como valores o almacenadas en variables)

## Características clave de la programación funcional en Java:

### Lambdas:

Las expresiones lambda permiten definir funciones de forma concisa. Son útiles cuando quieres pasar una pequeña función como argumento sin tener que escribir una clase completa.

```java
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.forEach(n -> System.out.println(n)); // Lambda para imprimir cada número
```

### Streams:

Los Streams permiten trabajar con colecciones de datos de manera declarativa, aplicando transformaciones como filtrado, mapeo, reducción, etc. Esto es clave para la programación funcional en Java, ya que facilita el procesamiento de datos de manera inmutable y sin efectos secundarios.

```java
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int sum = numbers.stream().mapToInt(n -> n).sum(); // Suma de todos los números
```

### Interfaces funcionales:

Las interfaces funcionales son interfaces que contienen un único método abstracto. Son útiles para definir funciones que pueden ser pasadas como argumentos.

```java
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    MathOperation add = (a, b) -> a + b;
    System.out.println(add.operation(1, 2)); // Imprime 3
```


### Inmutabilidad:
La programación funcional tiende a trabajar con datos inmutables. En lugar de modificar el estado de un objeto, se crean nuevas instancias con los nuevos valores. La inmutabilidad es importante porque evita efectos secundarios y facilita la concurrencia.


## Preguntas
- ¿Qué son los métodos de referencia (method references) en Java 8 y cómo se utilizan en la programación funcional?
- ¿Qué es la anotación @FunctionalInterface en Java y cuál es su propósito?
- ¿Qué son los lambdas en Java? ¿Cómo se usan?
- ¿Qué es un Stream en Java? Explica su uso.