# Dynamic proxies

Dynamic proxies in Java are a feature that allows developers to create proxy instances of interfaces at runtime. This can be useful for implementing methods that are not known at compile-time or for adding behavior such as logging, transaction management, or security checks around method calls on an object.

### Key Points about Dynamic Proxies

- Creation at Runtime:
    - Dynamic proxies are created at runtime using the java.lang.reflect.Proxy class.
    - They can be used to implement any interface by creating a proxy instance that dispatches method calls to an InvocationHandler.

- InvocationHandler Interface:
    - An interface that must be implemented to handle the method invocations on the proxy instance.
    - The invoke method of the InvocationHandler is called whenever a method is invoked on the proxy instance.

- Usage:
    - Commonly used in AOP (Aspect-Oriented Programming) to add cross-cutting concerns.
    - Useful in frameworks such as Spring for implementing transactional behavior, security, and remote method invocation (RMI).

### Example
``` java
public interface MyInterface {
    void myMethod();
}

public class MyInterfaceImpl implements MyInterface {
    @Override
    public void myMethod() {
        System.out.println("Executing method");
    }
}

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        MyInterface original = new MyInterfaceImpl();
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
            original.getClass().getClassLoader(),
            new Class<?>[]{MyInterface.class},
            new MyInvocationHandler(original)
        );

        proxyInstance.myMethod();
    }
}

``` 

### Output
``` bash
Before method call
Executing method
After method call
``` 