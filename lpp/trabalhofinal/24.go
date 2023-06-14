type Person struct {
    Name string
    Age  int
}

type Student struct {
    Person
    Grade int
}

func main() {
    p := Person{"John Doe", 30}
    fmt.Println(p.Name)
    fmt.Println(p.Age)

    s := Student{Person{"Jane Doe", 20}, 90}
    fmt.Println(s.Name)
    fmt.Println(s.Age)
    fmt.Println(s.Grade)
}
