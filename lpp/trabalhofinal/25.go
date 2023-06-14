package main

import (
	"fmt"
)

func factorial(n int) int {
	if n < 0 {
		panic("n cannot be negative")
	}
	if n == 0 {
		return 1
	}
	return n * factorial(n-1)
}

func main() {
	var n int
	fmt.Print("Enter a number: ")
	fmt.Scan(&n)
	fmt.Println("Factorial of", n, "is", factorial(n))
}
