package main

import "fmt"

func main() {
    a := 2 + 3 * 4
    fmt.Println(a) // imprime 14   
    
    /* Neste exemplo, o operador de multiplicação * tem a mesma precedência que o operador de adição +, então eles são avaliados da esquerda para a direita. 
    Primeiro, 3 é multiplicado por 4 (resultando em 12) e depois 2 é adicionado a 12 (resultando em 14).

    Existem alguns operadores, como o operador de atribuição = e o operador de comparação ==, que possuem associatividade à direita. 
    Isso significa que as operações são avaliadas da direita para a esquerda. */

    a = 2
    b := 3
    c := 4
    result := a == b && c == 4
    fmt.Println(result) // imprime false

    /* Neste exemplo, os operadores de comparação == são avaliados primeiro, comparando se a é igual a b e se c é igual a 4. 
    Depois o operador && é avaliado, comparando se as duas comparações são verdadeiras. 
    Como a é diferente de b, então o resultado é falso. */

}
