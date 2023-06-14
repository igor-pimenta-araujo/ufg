package main

import "fmt"

func main() {
	// Leitura do valor do salário mínimo
	var salarioMinimo float64
	fmt.Print("Digite o valor do salário mínimo: ")
	fmt.Scanln(&salarioMinimo)

	// Leitura do valor do salário do usuário
	var salarioUsuario float64
	fmt.Print("Digite o valor do salário do usuário: ")
	fmt.Scanln(&salarioUsuario)

	// Cálculo da quantidade de salários mínimos
	quantidadeSalariosMinimos := salarioUsuario / salarioMinimo

	// Exibição do resultado
	fmt.Printf("O usuário ganha %.2f salários mínimos\n", quantidadeSalariosMinimos)
}
