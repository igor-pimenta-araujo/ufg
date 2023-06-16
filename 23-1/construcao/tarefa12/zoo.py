import random
O_ANIMAL_CHAMADO = "O animal chamado: "
EMITIU_SOM = " emitiu o som: "

class Animal:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

    def emitir_som(self):
        # TODO will be implemented in the subclasses
        pass

    def movimento(self):
        # TODO will be implemented in the subclasses
        pass

class Cachorro(Animal):
    def emitir_som(self):
        print(O_ANIMAL_CHAMADO + self.nome + EMITIU_SOM + "au au")

    def movimento(self):
        print("O cachorro está correndo")


class Cavalo(Animal):
    def emitir_som(self):
        print(O_ANIMAL_CHAMADO + self.nome + EMITIU_SOM + "riirl")

    def movimento(self):
        print("O cavalo está correndo")


class Preguica(Animal):
    def emitir_som(self):
        print(O_ANIMAL_CHAMADO + self.nome + EMITIU_SOM + "sksjksljfkl")

    def movimento(self):
        print("A preguiça está subindo em árvores")


class Humano(Animal):
    def emitir_som(self):
        print(O_ANIMAL_CHAMADO + self.nome + EMITIU_SOM + "olá mundo")

    def movimento(self):
        print("O ser humano está andando")

class AnimalInvalidoException(Exception):
    pass

class Veterinario:
    def examinar(self, animal):
        if not isinstance(animal, (Cachorro, Cavalo, Preguica)):
            raise AnimalInvalidoException("Tipo de Animal Inválido")
        animal.emitir_som()

nomes = ['Alice', 'Bob', 'Carlos', 'Daniela', 'Eduardo', 'Fernanda', 'Gustavo', 'Helena', 'Igor', 'Julia']

veterinario = Veterinario()
cachorro = Cachorro(random.choice(nomes), 3)
cavalo = Cavalo("Pé de Pano", 5)
preguica = Preguica("Sid", 2)
humano = Humano(random.choice(nomes), 35)

veterinario.examinar(cachorro)
veterinario.examinar(cavalo)
veterinario.examinar(preguica)

try:
    veterinario.examinar(humano)
except AnimalInvalidoException:
    print("O veterinário não pode examinar o ser humano")
