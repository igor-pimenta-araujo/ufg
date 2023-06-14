package main

func main() {
	var n int

	//mostrar erro de sobrecarga de tipos
	n = 1
	n = 1.5 // vai dar o erro: cannot use 1.5 (type float64) as type int in assignment
	n = "1" // vai dar o erro: cannot use "1" (type string) as type int in assignment
}
