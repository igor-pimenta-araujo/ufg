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

func isEqual(p1, p2 Point2D) bool {
    return p1.x == p2.x && p1.y == p2.y
}

func main() {
    var p1 Point2D
    var p2 Point2D

    fmt.Println("Enter the coordinates of the first point:")
    fmt.Scan(&p1.x, &p1.y)
    fmt.Println("Enter the coordinates of the second point:")
    fmt.Scan(&p2.x, &p2.y)
    
    fmt.Println(isEqual(p1, p2))
}