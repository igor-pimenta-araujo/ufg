package main

import (
	"fmt"
)

type Ponto2D struct {
    x int
    y int
}

func main() {
    p1 := Ponto2D{1, 2}
    p2 := Ponto2D{3, 4}
    fmt.Println(p1, p2)
}
