function iterativeBinarySearch(array, number) { 
    debugger;
	let left = 0;
	let right = array.length - 1;
	let middle;
	while (right >= left) {
        middle = left + Math.floor((right - left) / 2);

		// If the element is present at the middle
		// itself
		if (array[middle] == number)
			return middle;

		// If element is smaller than middle, then
		// it can only be present in left subarray
		if (array[middle] > number)
			right = middle - 1;
			
		// Else the element can only be present
		// in right subarray
		else
			left = middle + 1;
	}

	// We reach here when element is not
	// present in array
	return -1;
}


function recursiveBinarySearch(arr, l, r, x){
	if (r >= l) {
		let mid = l + Math.floor((r - l) / 2);

		// If the element is present at the middle
		// itself
		if (arr[mid] == x)
			return mid;

		// If element is smaller than mid, then
		// it can only be present in left subarray
		if (arr[mid] > x)
			return recursiveBinarySearch(arr, l, mid - 1, x);

		// Else the element can only be present
		// in right subarray
		return recursiveBinarySearch(arr, mid + 1, r, x);
	}

	// We reach here when element is not
	// present in array
	return -1;
}

let arr = [ 1, 2, 3, 4, 10, 40 ];
let x = 10;
let n = arr.length
let resultIterative = iterativeBinarySearch(arr, x);
let resultBinary = recursiveBinarySearch(arr, 0, n - 1, x);

console.log("Iterative Binary Search");
(resultIterative == -1) ? console.log( "Element is not present in array") : console.log("Element is present at index " +resultIterative);
console.log("Recursive Binary Search");
(resultBinary == -1) ? console.log( "Element is not present in array") : console.log("Element is present at index " +resultBinary);


				

