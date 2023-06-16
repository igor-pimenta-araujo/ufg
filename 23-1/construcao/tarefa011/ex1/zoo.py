import random

class Animal:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade

    def emitir_som(self):
        # TODO Emitir som baseado no tipo de animal
        pass

    def movimento(self):
        # TODO Emitir corrida baseado no tipo de animal
        pass


class Cachorro(Animal):
    def emitir_som(self):
        print("au au")

    def movimento(self):
        print("O cachorro está correndo")


class Cavalo(Animal):
    def emitir_som(self):
        print("riirl")

    def movimento(self):
        print("O cavalo está correndo")


class Preguica(Animal):
    def emitir_som(self):
        print("sksjksljfkl")

    def movimento(self):
        print("A preguiça está subindo em árvores")


class AnimalTeste:
    def testar_sons(self):
        cachorro = Cachorro("Rex", 3)
        cavalo = Cavalo("Pé de Pano", 5)
        preguica = Preguica("Sid", 2)

        animais = [cachorro, cavalo, preguica]

        for animal in animais:
            animal.emitir_som()


class Veterinario:
    def examinar(self, animal):
        animal.emitir_som()


class Zoologico:
    def __init__(self):
        self.jaulas = []

    def adicionar_animal(self, animal):
        self.jaulas.append(animal)

    def visitar_zoologico(self):
        for animal in self.jaulas:
            animal.emitir_som()
            animal.movimento()


# Teste dos sons dos animais
teste = AnimalTeste()
teste.testar_sons()

nomes = ['Alice', 'Bob', 'Carlos', 'Daniela', 'Eduardo', 'Fernanda', 'Gustavo', 'Helena', 'Igor', 'Julia']

# Exame dos animais pelo veterinário
veterinario = Veterinario()
cachorro = Cachorro(random.choice(nomes), 3)
cavalo = Cavalo("Pé de Pano", 5)
preguica = Preguica("Sid", 2)

veterinario.examinar(cachorro)
veterinario.examinar(cavalo)
veterinario.examinar(preguica)

# Visita ao zoológico
zoologico = Zoologico()
zoologico.adicionar_animal(cachorro)
zoologico.adicionar_animal(cavalo)
zoologico.adicionar_animal(preguica)

zoologico.visitar_zoologico()
