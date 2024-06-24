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
### Other use cases

1. Logging

AOP can be used to log method execution, input parameters, output results, and exceptions. This helps in debugging and monitoring the application without cluttering the business logic with logging code.

``` java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Executed: " + joinPoint.getSignature().getName() + ", Returned: " + result);
    }
}
``` 

2. Security
AOP can be used to enforce security checks before allowing access to certain methods. This can include role-based access control or authentication checks.

``` java

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.example.service.*.*(..)) && @annotation(com.example.annotation.Secured)")
    public void checkSecurity(JoinPoint joinPoint) throws Throwable {
        // Perform security check
        System.out.println("Security check before executing: " + joinPoint.getSignature().getName());
    }
}
``` 

3. Transaction Management
AOP can be used to manage transactions, ensuring that a method executes within a transactional context. If the method fails, the transaction can be rolled back.

``` java

@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        // Begin transaction
        System.out.println("Transaction started");
        Object result;
        try {
            result = joinPoint.proceed();
            // Commit transaction
            System.out.println("Transaction committed");
        } catch (Exception e) {
            // Rollback transaction
            System.out.println("Transaction rolled back");
            throw e;
        }
        return result;
    }
}
```

4. Exception Handling
AOP can be used to centralize exception handling logic. This can help in handling exceptions consistently across the application.

``` java
@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception in: " + joinPoint.getSignature().getName() + ", Exception: " + exception.getMessage());
        // Custom exception handling logic
    }
}
``` 

5. Performance Monitoring
AOP can be used to measure the performance of methods by capturing the execution time.

``` java

@Aspect
@Component
public class PerformanceMonitoringAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature().getName() + ": " + (end - start) + " ms");
        return result;
    }
}
``` 
6. Caching
AOP can be used to implement caching mechanisms, storing method results to avoid redundant computations and improve performance.

``` java

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cache = new HashMap<>();

    @Around("execution(* com.example.service.*.*(..))")
    public Object cacheResult(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toShortString() + Arrays.toString(joinPoint.getArgs());
        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for: " + key);
            return cache.get(key);
        }
        Object result = joinPoint.proceed();
        cache.put(key, result);
        System.out.println("Caching result for: " + key);
        return result;
    }
}
``` 

7. Auditing
AOP can be used to track changes and log audit information, such as who made a change and when it was made.

``` java

@Aspect
@Component
public class AuditingAspect {

    @After("execution(* com.example.service.*.*(..))")
    public void audit(JoinPoint joinPoint) {
        // Log audit information
        System.out.println("Audit log: " + joinPoint.getSignature().getName() + " executed at " + new Date());
    }
}
``` 
