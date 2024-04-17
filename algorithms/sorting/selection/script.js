function selectionSort(array)
{
    let size = array.length;
    
    for (let i = 0; i < size - 1; i++)
    {
        let min_idx = i;
        for (let j = i + 1; j < size; j++)
            if (array[j] < array[min_idx])
                min_idx = j;

        var temp = array[min_idx];
        array[min_idx] = array[i];
        array[i] = temp;
    }
    
    return array;
}

let array = selectionSort([64, 25, 12, 22, 11, 14, 1, 7]);
console.log(array);