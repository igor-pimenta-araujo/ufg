package main

import (
    "math";
	"fmt"
)

type Point2D struct {
    x float64
    y float64
}

func distance(p1, p2 Point2D) float64 {
    return math.Sqrt(math.Pow(p2.x-p1.x, 2) + math.Pow(p2.y-p1.y, 2))
}

func main() {
    p1 := Point2D{1, 2}
    p2 := Point2D{3, 4}
    fmt.Println(distance(p1, p2))
}