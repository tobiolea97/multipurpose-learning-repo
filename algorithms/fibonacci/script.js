function fibonnaciFindIndex(n) {
    let a = 0, b = 1, c, i;
    if( n == 0)
        return a;
    for(i = 2; i <= n; i++)
    {
		c = a + b;
		a = b;
		b = c;
    }
    return b;
}

function fibonacciReturnArray(n) {
	let a = 0, b = 1, c, i;   
	if(n == 0)
		return [0];
	let array = [0, 1];
    for(i = 2; i <= n; i++)
    {
    	c = a + b;
    	a = b;
    	b = c;
		array.push(c);
    }
    return array;
}

function recursiveFibonacci(n) {
	debugger;
	if (n <= 1) {
		return n;
	} else {
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
}
 
let n = 3;
     
console.log("fibonnaciFindIndex");
console.log(fibonnaciFindIndex(n));

console.log("fibonacciReturnArray");
console.log(fibonacciReturnArray(n));

console.log("recursiveFibonacci");
console.log(recursiveFibonacci(n));


