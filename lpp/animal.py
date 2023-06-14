class Animal:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def show_info(self):
        print("Nome:", self.name)
        print("Idade:", self.age)

class Cat(Animal):
    def __init__(self, name, age):
        super().__init__(name, age)

cat = Cat("Whiskers", 3)
cat.show_info()  # Imprime "Nome: Whiskers" e "Idade: 3"
