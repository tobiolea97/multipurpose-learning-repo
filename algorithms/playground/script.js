function recursiveBinarySearch(array, left, right, number) {
	if(right >= left) {
		let middle = left + Math.floor((right - left) /2);
		if(array[middle] === number)
			return middle;
		if(array[middle] > number)
			return recursiveBinarySearch(array, left, middle - 1, number);
		if(array[middle] < number)
			return recursiveBinarySearch(array, middle + 1, right, number);
	}
	return -1;
}

let array = [1,2,3,4,5,6,7,8,9,10];
let index = recursiveBinarySearch(array, 0, array.length - 1, 2);

index != -1 ? console.log("Index: " + index) : console.log("Not found.")