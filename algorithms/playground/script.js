/*****************************************
*   Fibo
*****************************************/
const fibo = (number) => {
}
let arrayFibo = []
for(let i = 0; i < 15; i++) {
    arrayFibo.push(fibo(i));
}
//console.log(arrayFibo);

/*****************************************
*   Selection sort
*****************************************/
const selectionSort = (array) => {
} 
// console.log(selectionSort([3,5,8,9,6,4,1,2,7,0,100,-100,14,2]));


/*****************************************
*   Bubble sort
*****************************************/
const bubbleSort = (array) => {
    
} 
// console.log(bubbleSort([3,5,8,9,6,4,1,2,7,0,100,-100,14]));

/*****************************************
*   Insertion sort
*****************************************/
const insertionSort = (array) => {
} 
// console.log(insertionSort([3,5,8,9,6,4,1,2,7,0,100,-100,14]));

/*****************************************
*  Merge sort
*
*  Utilizamos recursion. Vamos a tener un metodo
*  mergeSort que recibe como parametro el array que queremos
*  ordenar
*
* 1) preguntamos por el tamaño del array recibido, si es igual a uno
*    significa que dividimos tanto el array recibido que solo nos quedamos
*    con un item, lo cual significa que podemos empezar a mergear
* 2) dividimos el array en 2 y los volcamos en 2 array nuevos (left y right)
* 3) volvemos a pasar llamar mergeSort (2 veces) pasandole left y right
* 4) mergeamos el proceso debería ser algo asi
    [2,8,12] [(1),4,15]                 → [1]
    [(2),8,12] [(1),4,15]               → [1,2]
    [(2),8,12] [(1),(4),15]             → [1,2,4]
    [(2),(8),12] [(1),(4),15]           → [1,2,4,8]
    [(2),(8),(12)] [(1),(4),15]         → [1,2,4,8,12]
    [(2),(8),(12)] [(1),(4),(15)]       → [1,2,4,8,12,15]
*****************************************/


const mergeSortWrapper = (array) => {
    return array;
}
console.log(mergeSortWrapper([3,5,8,9,6,4,1,2,7,0,100,-100,14]));

/*********************************************************************/
let sortedArray = [1,2,3,4,5,6,7,8,9,10,11,12];

/*****************************************
*   Recursive binary search
*****************************************/
const recursiveBinarySearch = () => {
}
// console.log(recursiveBinarySearch());

/*****************************************
*   Linear binary search
*****************************************/
const linearBinarySearch = () => {
}
// console.log(linearBinarySearch());