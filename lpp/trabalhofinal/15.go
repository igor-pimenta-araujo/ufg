package main

import "fmt"

func main() {
    x := 5
    y := 10

    // Estrutura de condicional if-else
    if x < y {
        fmt.Println("x é menor que y")
    } else {
        fmt.Println("x é maior ou igual a y")
    }

    // Estrutura de condicional switch
    z := "apple"
    switch z {
    case "apple":
        fmt.Println("z é uma maçã")
    case "banana":
        fmt.Println("z é uma banana")
    default:
        fmt.Println("z é outra coisa")
    }
}
