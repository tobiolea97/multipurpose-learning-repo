import java.util.*;

public class ArraysChallenges {

    public static void arrays() {
        // 1. Declaración e inicialización de un array
        int[] numbers = {5, 2, 9, 1, 6, 3};

        // 2. Acceso a elementos
        System.out.println("Elemento en índice 2: " + numbers[2]);  // 9

        // 3. Modificación de elementos
        numbers[2] = 10;
        System.out.println("Array después de modificar el índice 2: " + Arrays.toString(numbers)); // [5, 2, 10, 1, 6, 3]

        // 4. Recorrer un array con un bucle for
        System.out.print("Recorrido con for: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Recorrido con for-each
        System.out.print("Recorrido con for-each: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 5. Obtener la longitud del array
        System.out.println("Longitud del array: " + numbers.length);  // 6

        // 6. Búsqueda de un elemento
        int target = 6;
        boolean found = false;
        for (int number : numbers) {
            if (number == target) {
                found = true;
                break;
            }
        }
        System.out.println("¿El número " + target + " está en el array? " + found);  // true

        // 7. Ordenar el array
        Arrays.sort(numbers);
        System.out.println("Array ordenado: " + Arrays.toString(numbers));  // [1, 2, 3, 5, 6, 10]

        // 8. Copiar el array
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Array copiado: " + Arrays.toString(copiedArray));  // [1, 2, 3, 5, 6, 10]

        // 9. Comparar arrays
        boolean areEqual = Arrays.equals(numbers, copiedArray);
        System.out.println("¿Los arrays son iguales? " + areEqual);  // true

        // 10. Encontrar el valor máximo y mínimo
        int max = numbers[0];
        int min = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Valor máximo: " + max);  // 10
        System.out.println("Valor mínimo: " + min);  // 1

        // 11. Sumar los elementos del array
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Suma de los elementos: " + sum);  // 27

    }


    public static void main(String[] args) {
//        1. Encontrar el maximo de un array
        int[] estaVariableEsUnArray = new int[] {10,2,3,4,5,6,7,8,9};
        int max = encontrarMaximo(estaVariableEsUnArray);
        System.out.println("El maximo es: " + max);

//        2. Revertir un array
//        int[] array = new int[] {2,4,6,8,10};
//        int[] revertedArray = revertirArray(array);
//        for(int number : revertedArray) {
//            System.out.println(number);
//        }

//        3. Suma de pares
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(sumaDePares(arr));

//        4. Encontrar numero unico
//        int[] arr = {22, 3, 5, 2, 3, 5, 12};
//        System.out.println(encontrarNumeroUnico(arr));  // Salida: 5

//        5. Mover ceros al final
//        int[] arr = {0, 1, 0, 0, 14, 0, 4, 14, 3, 12};
//        System.out.println(Arrays.toString(moverCerosAlFinal(arr)));  // Salida: [1, 3, 12, 0, 0]

//        6. Rotar un array
//        Escribe un método que reciba un array y un número k y rote el array a la derecha k veces.
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(rotarArray(arr, 99)));

//        7. Producto de los elementos excepto el actual
//        Escribe un método que reciba un array de enteros y retorne un nuevo array donde cada elemento
//        es el producto de todos los elementos del array original excepto el actual.
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(productoExceptoActual(arr)));  // Salida: [24, 12, 8, 6]

//        8.  Eliminar duplicados
//        Escribe un método que reciba un array de enteros y elimine los duplicados, devolviendo un nuevo array con los elementos únicos.
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(Arrays.toString(eliminarDuplicados(arr)));  // Salida: [1, 2, 3]


    }

    public static int encontrarMaximo(int[] numeros) {
        int max = numeros[0];
        for (int numero : numeros) {
            max = max > numero ? max : numero;
        }
        return max;
    }

    public static int[] revertirArray(int[] numbers) {
        int length = numbers.length;
        int[] revertedArray = new int[length];
        int position = 0;
        for(int i = length - 1; i >= 0; i--) {
            revertedArray[position] = numbers[i];
            position++;
        }
        return revertedArray;
    }

    public static int sumaDePares(int[] numeros) {
        int suma = 0;
        for(int numero : numeros ) {
            if(numero % 2 == 0) {
                suma += numero;
            }
        }
        return suma;
    }

    public static int encontrarNumeroUnico(int[] numeros) {
        for(int i = 0; i < numeros.length ; i++) {
            int currentNumber = numeros[i];
            boolean repeated = false;
            for(int j = 0; j < numeros.length; j++) {
                if(i != j && currentNumber == numeros[j])
                    repeated = true;
            }
            if(!repeated) return currentNumber;
        }
        return -1;
    }

    public static int[] moverCerosAlFinal(int[] numeros) {
        int size = numeros.length;
        int[] newArray = new int[size];
        int left = 0,
            right = size - 1;
        for(int i = 0; i < numeros.length; i++) {
            int number = numeros[i];
            if(number == 0) {
                newArray[right--] = number;
            } else {
                newArray[left++] = number;
            }
        }
        return newArray;
    }

    public static int[] rotarArray(int[] numeros, int k) {
        int size = numeros.length;
        int[] newArray = new int[numeros.length];

        for(int i = 0; i < size; i++) {
            int newIndex = i + k;
            while(newIndex > size-1) {
                newIndex -= size;
            }
            newArray[newIndex] = numeros[i];
        }
        return newArray;
    }


    public static int[] productoExceptoActual(int[] numeros) {
        int size = numeros.length;
        int[] newArray = new int[numeros.length];
        for(int i = 0; i < size; i++) {
            int product = 1;
            for (int j = 0; j < size; j++) {
                if(i != j)
                    product = product * numeros[j];
            }
            newArray[i] = product;
        }
        return newArray;
    }

    public static int[] eliminarDuplicados(int[] numeros) {
        int size = numeros.length;
        int[] newArray = new int[0];
        int newArraySize = 0;

        for(int i = 0; i < size; i++) {
            int currentNumber = numeros[i];
            boolean isPresent = false;
            for (int j = 0; j < newArraySize; j++) {
                if(currentNumber == newArray[j])
                    isPresent = true;
            }

            if(!isPresent) {
//                int[] temp = newArray.clone();
//                newArray = new int[++newArraySize];
//                for (int j = 0; j < newArraySize - 1; j++ )
//                    newArray[j] = temp[j];
                newArray = Arrays.copyOf(newArray, ++newArraySize);
                newArray[newArraySize - 1] = currentNumber;
            }
        }
        return newArray;
    }


}
