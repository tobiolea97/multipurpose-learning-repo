function insertionSort(arr) {
    debugger
    let length = arr.length;
    for (let i = 1; i < length; i++) 
    {  
        let key = arr[i];  
        let j = i - 1;
        while ( j >= 0 && arr[j] > key) 
        {  
            arr[j + 1] = arr[j];  
            j = j - 1;  
        }  
        arr[j + 1] = key;  
    }
    return arr;
}

console.log(insertionSort([12,11,13,5,6,9]));