## JVM, el JRE y el JDK
La JVM (Java Virtual Machine) es una máquina virtual que ejecuta programas Java compilados en bytecode. La JVM es una parte fundamental de la plataforma Java, ya que permite que los programas Java se ejecuten en cualquier sistema operativo que tenga una implementación de la JVM.

La JRE (Java Runtime Environment) es un entorno de ejecución que proporciona la máquina virtual de Java (JVM) y las bibliotecas estándar de Java necesarias para ejecutar aplicaciones Java. La JRE es necesaria para ejecutar programas Java en un sistema operativo.

La JDK (Java Development Kit) es un kit de desarrollo que proporciona las herramientas necesarias para desarrollar aplicaciones Java. La JDK incluye la JRE, el compilador de Java (javac), las herramientas de depuración y otras utilidades necesarias para desarrollar, compilar y ejecutar programas Java.


## JIT

El compilador Just-In-Time (JIT) es una parte de la JVM que compila el bytecode de Java en código de máquina nativo en tiempo de ejecución. El JIT mejora el rendimiento de las aplicaciones Java al compilar y optimizar el código en tiempo de ejecución, lo que permite que las aplicaciones se ejecuten más rápido que si se interpretaran directamente desde el bytecode.

## La memoria en Java

- Heap: Almacena objetos y arrays creados en tiempo de ejecución.
- Stack: Almacena variables locales y referencias a objetos en tiempo de ejecución.
- Method Area: Almacena información sobre las clases y métodos cargados en la JVM.
- PC Register: Almacena la dirección de la instrucción actual en la pila de ejecución.
- Native Method Stack: Almacena información sobre métodos nativos utilizados en la aplicación.

## Class loader

El ClassLoader es un componente de la JVM que se encarga de cargar las clases en tiempo de ejecución. El ClassLoader carga las clases desde el sistema de archivos, la red o cualquier otra fuente de datos y las convierte en objetos de clase en la memoria.

## Classpath

Classpath es una variable de entorno que especifica la ubicación de las clases y bibliotecas que la JVM debe cargar al ejecutar una aplicación Java. El Classpath se utiliza para buscar y cargar las clases y bibliotecas necesarias para ejecutar una aplicación Java

## Packages

Los paquetes en Java son una forma de organizar y estructurar clases y otros elementos en un proyecto. Los paquetes proporcionan un espacio de nombres para evitar conflictos de nombres entre clases y facilitan la organización y la gestión de los componentes de una aplicación.

## Tipos de datos primitivos y no primitivos

- Primitivos: byte, short, int, long, float, double, char, boolean
- Referencia: String, Object, Arrays

## Wrappers

Los wrappers son clases que envuelven los tipos primitivos de Java y proporcionan métodos y funcionalidades adicionales para trabajar con esos tipos de datos. Por ejemplo, Integer es el wrapper para el tipo primitivo int, y proporciona métodos para convertir entre tipos primitivos y objetos, así como para realizar operaciones matemáticas y comparaciones.

## Variables de clase vs de instancia vs locales

- Variable de clase: Se declara con la palabra clave static y es compartida por todas las instancias de la clase.
- Variable de instancia: Se declara sin la palabra clave static y es única para cada instancia de la clase.
- Variable local: Se declara dentro de un método o bloque y solo es accesible dentro de ese ámbito.



## Preguntas
- ¿Qué es la reflexión en Java y cómo la utilizas en el desarrollo de aplicaciones?
- ¿Cuál es la diferencia entre un Stream secuencial y un Stream paralelo?
- Explica la diferencia entre Comparator y Comparable.
- ¿Cómo funciona la palabra clave final en Java?