package main

type Shape interface {
    Area() float64
}

type Rectangle struct {
    width, height float64
}

func (r Rectangle) Area() float64 {
    return r.width * r.height
}

type Circle struct {
    radius float64
}

func (c Circle) Area() float64 {
    return math.Pi * c.radius * c.radius
}

func main() {
    var s Shape
    s = Rectangle{10, 20}
    fmt.Println(s.Area())

    s = Circle{5}
    fmt.Println(s.Area())
}
