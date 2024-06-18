/*****************************************
*   Fibo
*****************************************/
const fibo = (number) => {
    let n1 = 0, n2 = 1, n3 = 0
    for(let i = 0; i < number; i++) {
        n3 = n2;
        n2 = n1;
        n1 = n2 + n3;
    }
    return n1
}
let arrayFibo = []
for(let i = 0; i < 15; i++) {
    arrayFibo.push(fibo(i));
}
// console.log(arrayFibo);

/*****************************************
*   Selection sort
*****************************************/
const selectionSort = (array) => {
    let size = array.length;
    for(let i = 0; i < size; i++) {
        let minorIndex = i;
        for(let j = i + 1; j < size; j++) {
            if(array[minorIndex] > array[j])
                minorIndex = j;
        }
        let temp = array[i]
        array[i] = array[minorIndex]
        array[minorIndex] = temp
    }
    return array
} 
// console.log(selectionSort([3,5,8,9,6,4,1,2,7,0,100,-100,14,2]));


/*****************************************
*   Bubble sort
*****************************************/
const bubbleSort = (array) => {
    let size = array.length;
    for(let i = size; i > 0; i--)
        for(let j = 0; j < i; j++)
            if(array[j] < array[j+1]){
                let temp = array[j+1]
                array[j+1] = array[j]
                array[j] = temp
            }
    return array
} 
// console.log(bubbleSort([3,5,8,9,6,4,1,2,7,0,100,-100,14]));

/*****************************************
*   Insertion sort
*****************************************/
const insertionSort = (array) => {  
    let size = array.length;
    for(let i = 1; i < size; i++) {
        let minor = array[i]
        j = i - 1;
        while(j >= 0 && array[j] > minor) {
            array[j+1] = array[j]
            j--
        }
        array[++j] = minor
    }
    return array
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
function conquer(array, left, right) {
    let i = 0, j = 0, k = 0
    while(i < left.length && j < right.length)
        array[k++] = left[i] < right[j] ? left[i++] : right[j++]
    while(i < left.length)
        array[k++] = left[i++]
    while(j < right.length)
        array[k++] = right[j++]
}

function divide(array) {
    let size = array.length
    if(size === 1)
        return

    let left = [], right = [],
        middle = Math.floor(size / 2);
    
    for(let i = 0; i < middle; i++)
        left.push(array[i])
    for(let i = middle; i < size; i++)
        right.push(array[i])

    divide(left)
    divide(right)
    conquer(array, left, right)

    return array
}
console.log(divide([3,5,8,9,6,4,1,2,7,0,100,-100,14]));

/*********************************************************************/
let sortedArray = [1,2,3,4,5,6,7,8,9,10,11,12];

/*****************************************
*   Recursive binary search
*****************************************/
const recursiveBinarySearch = (array, number, left, right) => {
    if(left > right)
        return -1

    let middle = Math.floor((right - left) / 2) + left
    
    if(number < array[middle])
        return recursiveBinarySearch(array, number, left, middle - 1)
    
    if(number === array[middle])
        return middle
    
    if(array[middle] < number)
        return recursiveBinarySearch(array, number, middle + 1, right)

}
// console.log(recursiveBinarySearch(sortedArray, 8, 0, sortedArray.length));

/*****************************************
*   Linear binary search
*****************************************/
const linearBinarySearch = () => {
}
// console.log(linearBinarySearch());

/*****************************************
*   Naive pattern searching
*****************************************/
function naiveSearch(pattern, string) {
    
}

const txt1 = "AABAACAADAABAABA";
const pat1 = "AABA";
// naiveSearch(pat1, txt1);

// Example 2
const txt2 = "agd";
const pat2 = "g";
// naiveSearch(pat2, txt2);