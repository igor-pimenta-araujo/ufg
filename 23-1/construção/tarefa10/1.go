package main

import "fmt"

func main() {
	// Leitura da idade em anos, meses e dias
	var anos, meses, dias int
	fmt.Print("Digite a idade em anos: ")
	fmt.Scanln(&anos)
	fmt.Print("Digite a idade em meses: ")
	fmt.Scanln(&meses)
	fmt.Print("Digite a idade em dias: ")
	fmt.Scanln(&dias)

	// Cálculo da idade em dias
	totalDias := (anos * 365) + (meses * 30) + dias

	// Exibição do resultado
	fmt.Printf("A idade expressa em dias é: %d dias\n", totalDias)
}