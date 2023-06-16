package main

import "fmt"

func main() {
	// Média dos números 8, 9 e 7
	media1 := (8 + 9 + 7) / 3

	// Média dos números 4, 5 e 6
	media2 := (4 + 5 + 6) / 3

	// Soma das duas médias
	somaMedias := media1 + media2

	// Média das médias
	mediaMedias := somaMedias / 2

	// Exibição dos resultados
	fmt.Printf("Média dos números 8, 9 e 7: %d\n", media1)
	fmt.Printf("Média dos números 4, 5 e 6: %d\n", media2)
	fmt.Printf("Soma das duas médias: %d\n", somaMedias)
	fmt.Printf("Média das médias: %d\n", mediaMedias)
}
