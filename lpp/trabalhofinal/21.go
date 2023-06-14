package main

import (
	"fmt"
	"errors"
)

func main() {
	// Criando um slice com números, sendo um deles 0
	numeros := []int{1, 2, 3, 4, 5, 0}

	// Chamando uma função que gerará erro
	_, err := dividirNumeros(numeros)
	if err != nil {
    	fmt.Println("Erro:", err)
	}
}

// Função que gera um erro
func dividirNumeros(numeros []int) (float64, error) {
	// Inicializando variável para o resultado
	result := 0.0

	// Iterando sobre os números do slice e dividindo-os por eles mesmos
	for _, num := range numeros {
    	// Se unm número for 0 retornar um erro
    	if num == 0 {
        	return result, errors.New("Não é possível dividir por zero.")
    	}

    	// Se não, fazer a divisão
    	result += float64(num) / float64(num)
	}

	// Retornando o resultado
	return result, nil
}
