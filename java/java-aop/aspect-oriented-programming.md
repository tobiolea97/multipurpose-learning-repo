# Aspect Oriented Programming

La Programación Orientada a Aspectos (AOP, por sus siglas en inglés, Aspect-Oriented Programming) es un paradigma de programación que tiene como objetivo aumentar la modularidad al permitir la separación de intereses transversales (cross-cutting concerns). Estos intereses transversales son aspectos del programa que afectan a múltiples módulos de un sistema, como la gestión de transacciones, el manejo de excepciones, la seguridad, el logging, entre otros.

En la Programación Orientada a Aspectos, estos intereses transversales se encapsulan en módulos llamados "aspectos". AOP permite que estos aspectos se apliquen de manera declarativa a los componentes del sistema, sin necesidad de modificar su código fuente directamente.

### Conceptos Clave de AOP
1. Aspecto (Aspect): Un módulo que encapsula un interés transversal. Por ejemplo, un aspecto de logging podría registrar todas las llamadas a métodos en una aplicación.

2. Punto de Corte (Join Point): Un punto en la ejecución del programa, como la llamada a un método o la ejecución de una excepción. Los aspectos se aplican en estos puntos.

3. Consejo (Advice): El código que se ejecuta en un punto de corte. Existen diferentes tipos de consejos, como before (antes de la ejecución), after (después de la ejecución) y around (alrededor de la ejecución).

4. Especificación del Punto de Corte (Pointcut): Una expresión que coincide con uno o más puntos de corte y determina dónde se aplicará un consejo.

5. Introducción (Introduction): Permite añadir métodos o campos a las clases existentes.

6. Tejido (Weaving): El proceso de aplicar aspectos a un código objetivo. El tejido puede ocurrir en tiempo de compilación, carga o ejecución.

### Ejemplo 
- Dependencia utilizada
``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

- Aspecto
``` java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("A method is about to be executed");
    }
}

```

- Configuración de Spring
``` java
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
}

```