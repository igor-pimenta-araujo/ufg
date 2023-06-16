package main

import "fmt"

func main() {
	// Leitura do saldo
	var saldo float64
	fmt.Print("Digite o valor do saldo: ")
	fmt.Scanln(&saldo)

	// Cálculo do saldo com reajuste de 15%
	saldoReajustado := saldo + (saldo * 0.15)

	// Exibição do saldo com reajuste
	fmt.Printf("Saldo com reajuste de 15%%: %.2f\n", saldoReajustado)
}
