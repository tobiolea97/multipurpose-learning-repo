# Array Deque

Double endend queue:

- Brinda la posibilidad de agregar elementos al principio o al final.
- No es sincornizado, por lo cual por default no es seguro para apps multihilo
- Eficiente para implementar pilas o colas.

### Metodos utilizados
``` java
 push()     // apilar
 pop()      // desapilar
 add()      // encolar
 remove()   // desencolar
 addFirst()
 addLast()
 removeFirst()
 removeLast()
```

# Priority Queue

Funciona como una cola pero que toma los elementos en base a un orden de prioridad. Ese orden puede ser el natural o uno establecido vía un Predicate al inicializar el objeto.

