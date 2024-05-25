function merge(array, leftHalf, rightHalf) {
    let leftSize = leftHalf.length;
    let rightSize = rightHalf.length;

    let i = 0, j = 0, k = 0;

    while (i < leftSize && j < rightSize) {
        if (leftHalf[i] <= rightHalf[j]) {
          array[k] = leftHalf[i];
          i++;
        }
        else {
          array[k] = rightHalf[j];
          j++;
        }
        k++;
    }

    while (i < leftSize) {
        array[k] = leftHalf[i];
        i++;
        k++;
      }
      
      while (j < rightSize) {
        array[k] = rightHalf[j];
        j++;
        k++;
      }
      console.log("merge realizado: ", leftHalf, rightHalf, array);
}

function mergeSort(array) {
    console.log("entrado a mergeSort", array);

    let length = array.length;
    
    if(length < 2)
        return

    let middle = Math.floor(length / 2);
    let leftHalf = [], rightHalf = [];

    for(let i = 0; i < middle; i++)
        leftHalf.push(array[i])
    
    for(let i = middle; i < length; i++)
        rightHalf.push(array[i])

    mergeSort(leftHalf);
    mergeSort(rightHalf);

    merge(array, leftHalf, rightHalf)
}

var array = [ 12, 11, 13, 5, 6, 7, 1,58,32,69,784,523,695,145,78,25 ];
mergeSort(array);
console.log(array);