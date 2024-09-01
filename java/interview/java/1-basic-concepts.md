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


-----------------------------------------------------

## IO Streams

Los streams de entrada/salida (I/O streams) en Java son una forma de leer y escribir datos desde y hacia diferentes fuentes y destinos, como archivos, redes, consolas, etc. Los streams de entrada se utilizan para leer datos, mientras que los streams de salida se utilizan para escribir datos.

## Streams

Los streams en Java 8 son una forma de procesar colecciones de datos de manera funcional y declarativa. Los streams permiten realizar operaciones como filtrado, mapeo, reducción y ordenación en colecciones de datos de forma eficiente y concisa.

## File I/O

La entrada/salida de archivos (File I/O) en Java se refiere a la lectura y escritura de datos desde y hacia archivos en el sistema de archivos. Java proporciona clases como File, FileInputStream, FileOutputStream, FileReader, FileWriter, etc., para trabajar con archivos en Java.

## BufferedI/O

Las clases BufferedInputStream y BufferedOutputStream en Java se utilizan para mejorar el rendimiento de la entrada/salida de datos al almacenar en búfer los datos leídos o escritos en memoria antes de transferirlos al sistema de archivos. Esto reduce la cantidad de operaciones de lectura/escritura en disco y mejora el rendimiento de la entrada/salida de archivos.

## sleep vs wait

- sleep:
pertenece a la clase Thread y se utiliza para pausar la ejecución del hilo actual durante un tiempo determinado en milisegundos. Durante este tiempo, el hilo permanece en estado de bloqueo temporal (timed waiting) y no ejecuta ningún código. Su propósito principal es suspender la ejecución de un hilo sin liberar los recursos ni la posesión de cualquier monitor que el hilo pueda estar sosteniendo.

- wait
pertenece a la clase Object y se utiliza en el contexto de la sincronización de hilos. Se invoca sobre un objeto que un hilo tiene bloqueado (mediante un synchronized). El hilo que llama a wait libera el bloqueo del objeto y entra en el estado de espera (waiting) hasta que otro hilo lo notifique mediante notify() o notifyAll(). Su propósito es permitir la sincronización de hilos, permitiendo que un hilo espere a que otro hilo complete alguna tarea antes de continuar.

## Synchronized

La palabra clave synchronized en Java se utiliza para crear secciones críticas de código que deben ser ejecutadas por un solo hilo a la vez. Cuando un hilo adquiere el bloqueo de un objeto mediante synchronized, ningún otro hilo puede ejecutar el código sincronizado hasta que el primer hilo libere el bloqueo.

## Volatile keyword

La palabra clave volatile en Java se utiliza para indicar que una variable puede ser modificada por múltiples hilos y que los cambios en la variable deben ser visibles para todos los hilos. La palabra clave volatile evita que los hilos almacenen en caché los valores de la variable y garantiza que los cambios en la variable sean visibles para todos los hilos.

## string vs stringbuilder vs stringbuffer

- String: Inmutable, no se puede modificar una vez creada. Cada operación de modificación crea una nueva cadena en memoria.
- StringBuilder: Mutable, se puede modificar sin crear una nueva instancia. Más eficiente para operaciones de concatenación y modificación de cadenas.
- StringBuffer: Similar a StringBuilder, pero sincronizado y seguro para hilos. Menos eficiente que StringBuilder en entornos no concurrentes.

## ¿Qué es un framework?

Conjunto de herramientas, bibliotecas y reglas que proporcionan una estructura predefinida para desarrollar aplicaciones o soluciones en un lenguaje de programación específico.

## ¿Qué es spring?

Spring es un framework que se enfoca en proporcionar una infraestructura sólida para manejar las preocupaciones comunes en las aplicaciones empresariales, como la:

- Gestión de transacciones
- La inyección de dependencias
- La integración con bases de datos
- Seguridad

## ¿Qué es Springboot?

Framework que simplifica la configuración y el desarrollo de aplicaciones al proporcionar una serie de configuraciones automáticas y herramientas que permiten a los desarrolladores centrarse más en la lógica de la aplicación en lugar de en la configuración manual del proyecto. Se ocupa de:

- Configuración automática
- Embalado sencillo
- Dependencias administradas (starters)
- Microservicios

## ¿Qué es la reflexión y como se usa en el desarrollo de aplicaciones?

Es una herramienta que permite inspeccionar o modifcar el comportamiento de un programa en tiempo de ejecución. Se usa para examinar o modificar las clases, interfaces, métodos y campos de un objeto en tiempo de ejecución, incluso si no conoces los nombres de estas estructuras en tiempo de compilación.

Se utiliza el objeto class.forName() para obtener la clase de un objeto y luego se puede obtener los métodos, campos, interfaces, etc. de la clase.

No es recomendable usar la reflexión en aplicaciones de producción, ya que puede ser inseguro y lento.

## ¿Cuál es la diferencia entre @Component, @Service, @Repository y @Configuration en Spring Boot?

### @Component

Se usa cuando no hay un propósito específico, es decir, cuando la clase no es un servicio o un repositorio, pero aún necesitas que Spring la gestione como un bean.

### @Service

Service es una especialización de Component que se utiliza para indicar que la clase es un servicio. Un servicio en la arquitectura de capas es donde resides la lógica de negocio.

### @Repository

Repository es otra especialización de Component que se utiliza para indicar que la clase es un repositorio. Un repositorio es responsable de la interacción con la base de datos, típicamente a través de consultas y operaciones CRUD. También traduce las excepciones de la base de datos a excepciones de Spring.

### @Configuration

Configuration se utiliza para indicar que la clase es una clase de configuración de Spring. Las clases de configuración de Spring se utilizan para definir beans y configurar la aplicación de Spring.

## ¿Que es @Autowired?

@Autowired es una anotación de Spring que se utiliza para inyectar dependencias automáticamente en los beans de Spring. Spring escanea el contexto de la aplicación en busca de beans que coincidan con el tipo de la propiedad o el método anotado con @Autowired y los inyecta automáticamente.

## ¿Cómo implementarías la autenticación basada en token JWT en una aplicación Spring Boot?

1 - Agregar las dependencias de Maven
2 - Crear una clase de configuración para la seguridad
3 - Crear un filtro de autenticación
4 - Crear un proveedor de autenticación, que se encargará de autenticar al usuario y generar el token JWT
5 - Proteger las rutas creando un filtro de autorización para validar el token JWT

## ¿Cómo implementarías la tolerancia a fallos en una aplicación Spring Boot?

Implementar la tolerancia a fallos en una aplicación Spring Boot implica diseñar y configurar la aplicación para que sea capaz de manejar fallos de manera eficaz y continuar funcionando o recuperarse rápidamente.

Algunas estrategias comunes para implementar la tolerancia a fallos en una aplicación Spring Boot incluyen:

- Circuit Breaker: Un Circuit Breaker (cortocircuito) es un patrón de diseño que permite que una aplicación detecte fallos en servicios externos y actúe en consecuencia para evitar sobrecargar esos servicios o realizar llamadas innecesarias. Se utilizan bibliotecas como Resilience4j o Spring Cloud Circuit Breaker para implementar Circuit Breakers en aplicaciones Spring Boot.

- Retries: Implementar reintentos automáticos en caso de fallos transitorios en llamadas a servicios externos. Se pueden utilizar bibliotecas como Spring Retry o Resilience4j para configurar reintentos automáticos en métodos específicos.

- Timeouts: Configurar tiempos de espera adecuados para las llamadas a servicios externos para evitar bloqueos o cuellos de botella en la aplicación. Se pueden configurar tiempos de espera globales o específicos para cada llamada utilizando propiedades de configuración en Spring Boot.

- Fallbacks: Proporcionar valores predeterminados o alternativos en caso de fallos en llamadas a servicios externos.

- Backoff: Implementar estrategias de backoff para reintentar llamadas a servicios externos con intervalos de tiempo crecientes en caso de fallos.

- Bulkhead: Separar y limitar el acceso a recursos críticos para evitar que un fallo en un componente afecte a otros componentes de la aplicación.

- Cache: Utilizar cachés para almacenar resultados de operaciones costosas y evitar llamadas innecesarias a servicios externos.

- Descentralización y Redundancia
  A nivel de arquitectura, puedes diseñar tu aplicación para que tenga redundancia en los servicios, utilizando patrones como microservicios o arquitecturas distribuidas que permitan distribuir la carga y evitar puntos únicos de fallo.

## ¿Cuál es la diferencia entre una conexión JDBC y una conexión JNDI?

### JDBC:

- Es una conexión directa a la base de datos desde el código de la aplicación.
- Los detalles de la conexión (URL, usuario, contraseña) están en el código de la aplicación.
- Es más adecuado para aplicaciones simples o de pequeña escala.

### JNDI:

- Es una conexión a la base de datos gestionada a través de un recurso JNDI en el servidor de aplicaciones.
- La configuración de la base de datos está separada del código y es gestionada por el servidor.
- Es más adecuado para aplicaciones grandes y complejas que requieren gestión centralizada y reutilización de configuraciones.

## ¿Qué es el patrón DAO (Data Access Object) y cuál es su propósito en el desarrollo de aplicaciones Java?

El patrón DAO (Data Access Object) es un patrón de diseño estructural que proporciona una abstracción sobre las operaciones de acceso a datos en una aplicación. En esencia, el patrón DAO separa la lógica de negocio de la lógica de acceso a datos, permitiendo que la aplicación interactúe con la base de datos de una manera consistente y desacoplada.

El propósito principal de este patrón es encapsular el código que accede a la base de datos y proporcionar una interfaz clara para realizar operaciones de lectura, escritura, actualización y eliminación (CRUD) en una fuente de datos (que podría ser una base de datos, un archivo, etc.).

## ¿Qué es la anotación @Transactional en Spring y cómo la utilizarías en un método de servicio?

La anotación @Transactional se utiliza para indicar que un método o clase debe ser ejecutado dentro de una transacción. Al utilizar esta anotación, Spring se encarga automáticamente de:

Iniciar una transacción al comienzo de la ejecución del método.
Comprometer (commit) la transacción si el método se ejecuta con éxito.
Revertir (rollback) la transacción si se lanza una excepción durante la ejecución del método

## ¿Qué es HATEOAS (Hypermedia as the Engine of Application State) y cómo se aplica en el desarrollo de APIs RESTful?

HATEOAS se refiere a la capacidad de una API RESTful para guiar al cliente a través de las interacciones posibles con el servicio utilizando hipervínculos (enlaces) dentro de las representaciones de recursos.

En una API RESTful que implementa HATEOAS, cada respuesta de la API incluye no solo los datos solicitados, sino también enlaces a otras acciones posibles relacionadas con ese recurso. Esto permite que el cliente navegue por la API sin necesidad de conocer de antemano la estructura o los endpoints disponibles.

## ¿Cuál es la diferencia entre un Stream secuencial y un Stream paralelo?

### Stream secuencial:

- Un Stream secuencial procesa los elementos de manera secuencial, uno a la vez, en un solo hilo de ejecución.
- Es útil para operaciones que no se benefician de la paralelización o que pueden ser sensibles al orden de los elementos.
- Se puede crear un Stream secuencial a partir de una colección o de un Stream paralelo utilizando el método sequential().

### Stream paralelo:

- Un Stream paralelo procesa los elementos de manera concurrente, utilizando múltiples hilos de ejecución para acelerar el procesamiento.
- Es útil para operaciones que se pueden paralelizar, como operaciones de filtrado, mapeo y reducción.
- Se puede crear un Stream paralelo a partir de una colección o de un Stream secuencial utilizando el método parallel().
- Se debe tener cuidado al utilizar Streams paralelos, ya que pueden introducir complejidad y posibles problemas de concurrencia en la aplicación.

### ¿Cuándo elegirías una solución NoSQL sobre una base de datos relacional en una aplicación Java Backend?

Algunas situaciones en las que podría ser más adecuado utilizar una base de datos NoSQL en lugar de una base de datos relacional en una aplicación Java Backend incluyen:

- Escalabilidad horizontal: Las bases de datos NoSQL suelen ser más adecuadas para escalar horizontalmente y manejar grandes volúmenes de datos distribuidos en clústeres de servidores.
- Flexibilidad en el esquema de datos: Las bases de datos NoSQL permiten un esquema de datos flexible y dinámico, lo que facilita la adaptación a cambios en los requisitos de la aplicación.
- Velocidad y rendimiento: Las bases de datos NoSQL suelen ser más rápidas y eficientes para ciertos tipos de consultas y operaciones, como consultas de lectura masiva o escrituras concurrentes.
- Modelado de datos complejos: Las bases de datos NoSQL son más adecuadas para modelar datos complejos y no estructurados, como documentos JSON o grafos.
- Escenarios de Big Data: Las bases de datos NoSQL son más adecuadas para escenarios de Big Data, como análisis de datos en tiempo real, procesamiento de eventos o almacenamiento de datos no estructurados.

## ¿Qué son los métodos de referencia (method references) en Java 8 y cómo se utilizan en la programación funcional?

Los métodos de referencia son una característica de Java 8 que permite referenciar métodos existentes o constructores de clases en lugar de definir una expresión lambda. Los métodos de referencia se utilizan en la programación funcional para simplificar la escritura de expresiones lambda y mejorar la legibilidad del código.

## ¿Qué es la anotación @FunctionalInterface en Java y cuál es su propósito?

La anotación @FunctionalInterface se utiliza para indicar que una interfaz de Java es una interfaz funcional. Una interfaz funcional es una interfaz que tiene un único método abstracto y puede ser utilizada como una expresión lambda en programación funcional.

## ¿Qué es Spring WebFlux y cuál es su propósito en el desarrollo de aplicaciones reactivas?

Spring WebFlux es un módulo de Spring Framework que proporciona soporte para el desarrollo de aplicaciones reactivas en Java. El propósito de Spring WebFlux es permitir a los desarrolladores crear aplicaciones reactivas que sean escalables, eficientes y resistentes a fallos.

La programación reactiva se basa en el principio de reactividad, que se centra en la capacidad de responder a eventos y cambios de manera eficiente y en tiempo real. Spring WebFlux utiliza el modelo de programación reactiva basado en el patrón de diseño Reactor para manejar operaciones asíncronas y no bloqueantes.

#### Componentes Principales en Programación Reactiva

- Publisher (Publicador): Es una fuente de datos que emite elementos a lo largo del tiempo.
- Subscriber (Suscriptor): Es el que recibe los elementos emitidos por el Publisher.
- Subscription (Suscripción): Es el contrato entre el Publisher y el Subscriber, que controla la emisión de elementos.
- Processor (Procesador): Actúa tanto como Publisher y Subscriber, permitiendo transformar los datos a medida que pasan por el flujo.

## Programación reactiva

