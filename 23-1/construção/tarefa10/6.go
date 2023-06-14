package main

import "fmt"

func main() {
	// Leitura do número inteiro
	var numero int
	fmt.Print("Digite um número inteiro: ")
	fmt.Scanln(&numero)

	// Cálculo do antecessor e sucessor
	antecessor := numero - 1
	sucessor := numero + 1

	// Exibição do antecessor e sucessor
	fmt.Printf("Antecessor: %d\n", antecessor)
	fmt.Printf("Sucessor: %d\n", sucessor)
}
