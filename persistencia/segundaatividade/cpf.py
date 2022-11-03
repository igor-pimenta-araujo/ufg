import json

def ler_json(cpf):
    try:
        with open(cpf + ".json", "r") as read_file:
            data = json.load(read_file)
            return data
    except FileNotFoundError:
        return "Arquivo não encontrado"

def escrever_json(cpf, data):
    with open(cpf + ".json", "w") as write_file:
        json.dump(data, write_file)   

while True:
    cpf = input("Digite o CPF: ")
    nome = input("Digite o nome: ")
    idade = input("Digite a idade: ")
    salario = input("Digite o salario: ")
    cargo = input("Digite o cargo: ")
    habilidades = []
    while True:
        habilidade = input("Digite uma habilidade(digite sair para parar de escrever habilidades): ")
        if habilidade == 'sair':
            break
        habilidades.append(habilidade)

    data = dict(
        cpf = cpf,
        nome = nome,
        idade = idade,
        salario = salario,
        cargo = cargo,
        habilidades = habilidades
    )

    escrever_json(cpf, data)
    keep_going = input("Deseja continuar? (S/n) ") != "n"
    if not keep_going: break

while True:
    cpf = input("Digite o CPF que deseja ler: ")
    print(ler_json(cpf))
    keep_going = input("Deseja continuar? (S/n) ") != "n"
    if not keep_going: break
    