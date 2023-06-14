package main

import "fmt"

func main() {
    // Estrutura de repetição for
    for i := 0; i < 5; i++ {
        fmt.Println("Valor de i:", i)
    }

    // Estrutura de repetição while
    j := 0
    for j < 5 {
        fmt.Println("Valor de j:", j)
        j++
    }

    // Estrutura de repetição for-range
    k := []string{"item 1", "item 2", "item 3"}
    for index, value := range k {
        fmt.Println("Index:", index, "Value:", value)
    }
}