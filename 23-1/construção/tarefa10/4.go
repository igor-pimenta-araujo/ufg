package main

import "fmt"

func main() {
	// Leitura da porcentagem do IPI
	var ipi float64
	fmt.Print("Digite a porcentagem do IPI a ser acrescido: ")
	fmt.Scanln(&ipi)

	// Leitura dos dados da peça 1
	var codigoPeca1 string
	var valorUnitarioPeca1 float64
	var quantidadePeca1 int

	fmt.Print("Digite o código da peça 1: ")
	fmt.Scanln(&codigoPeca1)
	fmt.Print("Digite o valor unitário da peça 1: ")
	fmt.Scanln(&valorUnitarioPeca1)
	fmt.Print("Digite a quantidade de peças 1: ")
	fmt.Scanln(&quantidadePeca1)

	// Leitura dos dados da peça 2
	var codigoPeca2 string
	var valorUnitarioPeca2 float64
	var quantidadePeca2 int

	fmt.Print("Digite o código da peça 2: ")
	fmt.Scanln(&codigoPeca2)
	fmt.Print("Digite o valor unitário da peça 2: ")
	fmt.Scanln(&valorUnitarioPeca2)
	fmt.Print("Digite a quantidade de peças 2: ")
	fmt.Scanln(&quantidadePeca2)

	// Cálculo do valor total a ser pago
	valorTotal := (valorUnitarioPeca1*float64(quantidadePeca1) + valorUnitarioPeca2*float64(quantidadePeca2)) * (ipi/100 + 1)

	// Exibição do valor total a ser pago
	fmt.Printf("Valor total a ser pago: %.2f\n", valorTotal)
}
