import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MapChallenges {
    //    Ejercicio 1: Contar la frecuencia de palabras en una cadena
//    Dada una cadena de texto, crea un método que cuente cuántas veces aparece cada palabra.
//    Devuelve un HashMap donde la clave sea la palabra y el valor sea la frecuencia.
    public static void countWords() {
        String array = "manzana Pera Manzana Uva PERA";
        List<String> words = Arrays.stream(array.split(" ")).toList();
        Map<String, Integer> wordCount = new HashMap<>();

        words.stream()
                .forEach((word) -> {
                    word = word.toUpperCase();
                    wordCount.put(
                            word,
                            wordCount.containsKey(word) ?
                                    wordCount.get(word) + 1 :
                                    1
                    );
                });

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        System.out.println(wordCount);
    }

    //    Ejercicio 3: Contar caracteres repetidos en una cadena
//    Dada una cadena, crea un método que cuente cuántas veces aparece cada carácter.
//    Devuelve un HashMap dondela clave sea el carácter y el valor sea la cantidad de veces que aparece.
    public static void countCharacters() {
        String word = "banana";
        List<String> characters = Arrays.stream(word.split("|")).toList();
        Map<String, Integer> charactersCounter = new HashMap<>();

        characters.stream()
                .forEach(
                        (character) -> {
                            charactersCounter.put(
                                    character,
                                    charactersCounter.containsKey(character) ?
                                            charactersCounter.get(character) + 1 :
                                            1
                            );
                        }
                );

        System.out.println(charactersCounter.toString());
    }

    //    Ejercicio 4: Traductor simple
//    Crea un programa que actúe como un traductor de palabras utilizando un HashMap.
//    La clave será la palabra en español, y el valor será su traducción en inglés.
//    El programa debe permitir agregar traducciones, eliminar palabras, y buscar la traducción de una palabra en particular.
    public static void translator() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("perro", "dog");
        dictionary.put("gato", "cat");
        dictionary.put("pez", "fish");
        dictionary.put("vaca", "cow");

        for (Map.Entry<String, String> translation : dictionary.entrySet()) {
            System.out.printf(
                    "La palabra %s se traduce como %s al ingles\n",
                    translation.getKey().toUpperCase(),
                    translation.getValue().toUpperCase()
            );
        }

        String spanishWord = "perro";
        System.out.printf("La traducción de ", spanishWord, " es ", dictionary.get(spanishWord));
    }


    //    Ejercicio 6: Agrupar palabras por su longitud
    //    Dada una lista de palabras, agrúpalas en un HashMap donde la clave sea la longitud de la palabra, y el
    //    valor sea una lista de palabras de esa longitud.
    //
    //    Entrada: ["manzana", "pera", "uva", "banana", "limón"]
    //    Salida: {4=[pera, uva], 5=[limón], 7=[manzana, banana]}
    public static void groupWordsByLength() {
        String[] words = {"manzana", "pera", "uva", "limon", "perro", "to", "tobi"};
        Map<Integer, String[]> groups = new HashMap<>();
        Arrays.stream(words)
                .forEach((word) -> {
                    int length = word.length();
                    String[] currentGroup = groups.get(length);
                    String[] newGroup;
                    if (currentGroup == null) {
                        newGroup = new String[]{word};
                    } else {
                        newGroup = Arrays.copyOf(currentGroup, currentGroup.length + 1);
                        newGroup[currentGroup.length] = word;
                    }
                    groups.put(length, newGroup);
                });

        for (Map.Entry<Integer, String[]> group : groups.entrySet()) {
            System.out.printf("Length: %d | %s\n", group.getKey(), Arrays.toString(group.getValue()));
        }
    }

    //    Ejercicio 7: Comparar dos HashMap
//    Crea un método que reciba dos HashMap y devuelva true si son iguales (contienen las mismas claves con los
//    mismos valores) y false en caso contrario.
    public static void compareMaps() {
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "Tobias");
        map1.put(2, "Silvia");
        map1.put(3, "Humbert");

        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(1, "Tobias");
        map2.put(2, "Silvia");
        map2.put(3, "Humbert");

        AtomicBoolean sameContent = new AtomicBoolean(true);

        map1.keySet()
                .stream()
                .forEach((key) -> {
                    if (map1.get(key) != map2.get(key)) {
                        sameContent.set(false);
                        return;
                    }
                });

        System.out.printf("Los maps %sson iguales", sameContent.get() ? "" : "no ");
    }

    //    Ejercicio 9: Ordenar por claves
//    Dado un HashMap, escribe un programa que ordene las entradas del mapa por sus claves. Luego, imprime el mapa ordenado.
//    Ejemplo:
//    Entrada: {C=5, A=2, B=8}
//    Salida: {A=2, B=8, C=5}
    public static void sortMap() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("R", 2);
        hashMap.put("B", 8);
        hashMap.put("C", 5);

        System.out.println("HashMap original:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Convertir el HashMap en un TreeMap (se ordena automáticamente por las claves)
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);

        // Imprimir el TreeMap (ordenado por claves)
        System.out.println("\nTreeMap ordenado:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }

    //    Ejercicio 10: Intersección de dos mapas
//    Dado dos HashMap, escribe un método que devuelva un nuevo HashMap que contenga solo las entradas (clave-valor)
//    que aparecen en ambos mapas.
//    Ejemplo:
//    Mapa 1: {A=1, B=2, C=3}
//    Mapa 2: {B=2, C=4, D=5}
//    Salida: {B=2}
    public static void intersection() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 2);
        map2.put("C", 4);
        map2.put("D", 5);

        Map<String, Integer> intersection = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())) {
                intersection.put(entry.getKey(), entry.getValue());
            } else {
                System.out.printf("%s = %d does not exist on the second map\n", entry.getKey(), entry.getValue());
            }
        }
        System.out.printf("\n\nIntersection\n");
        intersection.entrySet().stream().forEach(System.out::println);
    }


//    Ejercicio 11: Contar ocurrencias de números en un arreglo
//    Dado un arreglo de enteros, utiliza un HashMap para contar la cantidad de veces que aparece cada número.
//    Ejemplo:
//    Entrada: [4, 5, 6, 5, 4, 3]
//    Salida: {4=2, 5=2, 6=1, 3=1}
    public static void countOccurrencies() {
        int[] numbers = new int[]{4, 5, 6, 5, 4, 3};
        Map<Integer, Integer> occurrencies = new HashMap<>();

        Arrays.stream(numbers)
                .forEach(
                        (number) -> {
                            occurrencies.put(
                                    number,
                                    occurrencies.getOrDefault(number, 0) + 1
                            );
                        }
                );
        occurrencies.entrySet().stream().forEach(System.out::println);
    }

//    Ejercicio 12: Histograma de edades
//    Crea un programa que lea una lista de edades (enteros) yuse un HashMap para agrupar las edades
//    en rangos (ejemplo: 0-10, 11-20, etc.). El programa debe contar cuántas personas hay en cada rango de edad.

    public static void main(String[] args) {
//        countWords();
//        countCharacters();
//        translator();
//        groupWordsByLength();
//        compareMaps();
//        sortMap();
//        intersection();
//        countOccurrencies();
    }
}
