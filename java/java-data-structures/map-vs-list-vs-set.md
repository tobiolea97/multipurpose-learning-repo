# Map vs List vs Set

## Map
- Propósito: Almacenar pares clave-valor.
- Interfaz principal: java.util.Map
- Implementaciones comunes: HashMap, TreeMap, LinkedHashMap
#### Características:
- Las claves son únicas; no puede haber duplicados.
- Permite el acceso directo a los valores mediante sus claves.
- Orden de iteración puede variar según la implementación (p. ej., HashMap no garantiza un orden específico, mientras que TreeMap ordena las entradas según las claves y LinkedHashMap mantiene el orden de inserción).

## List
- Propósito: Almacenar una secuencia ordenada de elementos.
- Interfaz principal: java.util.List
- Implementaciones comunes: ArrayList, LinkedList, Vector
#### Características:
- Permite elementos duplicados.
- Los elementos se pueden acceder por su índice (posición).
- El orden de los elementos se mantiene tal como se insertan.

## Set
- Propósito: Almacenar un conjunto de elementos únicos.
- Interfaz principal: java.util.Set
- Implementaciones comunes: HashSet, TreeSet, LinkedHashSet

#### Características:
- No permite elementos duplicados.
- No hay un acceso directo por índice.
- El orden de iteración puede variar según la implementación (p. ej., HashSet no garantiza un orden específico, TreeSet ordena los elementos y LinkedHashSet mantiene el orden de inserción).