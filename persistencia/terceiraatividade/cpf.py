import xml.etree.ElementTree as ET

def ler_xml(sended_cpf):
    tree = ET.parse(sended_cpf + ".xml")
    root = tree.getroot()
    data = {}
    for child in root:
        if child.tag == "Habilidades":
            data[child.tag] = []
            for i in child:
                data[child.tag].append(i.text)
        else:
            data[child.tag] = child.text
    return data

def escrever_xml(sended_cpf, data):
    root = ET.Element("Pessoa")
    cpf = ET.SubElement(root, "CPF")
    cpf.text = data.get("cpf")
    nome = ET.SubElement(root, "Nome")
    nome.text = data.get("nome")
    idade = ET.SubElement(root, "Idade")
    idade.text = data.get("idade")
    salario = ET.SubElement(root, "Salario")
    salario.text = data.get("salario")
    cargo = ET.SubElement(root, "Cargo")
    cargo.text = data.get("cargo")
    for i in data.get("habilidades"):
        habilidades = ET.SubElement(root, "Habilidades")
        habilidade = ET.SubElement(habilidades, "Habilidade")
        habilidade.text = i        
    tree = ET.ElementTree(root)
    tree.write(sended_cpf + ".xml")

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

    escrever_xml(cpf, data)
    keep_going = input("Deseja continuar? (S/n) ") != "n"
    if not keep_going: break

while True:
    cpf = input("Digite o CPF que deseja ler: ")
    print(ler_xml(cpf))
    keep_going = input("Deseja continuar? (S/n) ") != "n"
    if not keep_going: break
    