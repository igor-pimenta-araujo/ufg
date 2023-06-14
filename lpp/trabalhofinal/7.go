package main

import "fmt"

func main() {
    x := 42
    fmt.Println("Valor de x:", x)

    {
        fmt.Println("Escopo interno")
        y := 43
        fmt.Println("Valor de y:", y)
    }

    // y não está disponível neste escopo
    // fmt.Println("Valor de y:", y) // erro de compilação
}
