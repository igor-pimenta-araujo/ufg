class Produto:
    def __init__(self, nomeloja, preco):
        self._nomeloja = nomeloja
        self._preco = preco
        self._descricao = "Produto de informática"

    def get_nomeloja(self):
        return self._nomeloja

    def set_nomeloja(self, nomeloja):
        self._nomeloja = nomeloja

    def get_preco(self):
        return self._preco

    def set_preco(self, preco):
        self._preco = preco

    def get_descricao(self):
        return self._descricao


class Mouse(Produto):
    def __init__(self, nomeloja, preco, tipo):
        super().__init__(nomeloja, preco)
        self._tipo = tipo

    def get_tipo(self):
        return self._tipo

    def set_tipo(self, tipo):
        self._tipo = tipo

    def get_descricao(self):
        descricao_pai = super().get_descricao()
        return f"{descricao_pai}. Tipo: {self._tipo}"


class Livro(Produto):
    def __init__(self, nomeloja, preco, autor):
        super().__init__(nomeloja, preco)
        self._autor = autor

    def get_autor(self):
        return self._autor

    def set_autor(self, autor):
        self._autor = autor

    def get_descricao(self):
        descricao_pai = super().get_descricao()
        return f"{descricao_pai}. Autor: {self._autor}"


class ProdutoTeste:
    def __init__(self):
        self.carrinho = []

    def adicionar_produto(self, produto):
        self.carrinho.append(produto)

    def mostrar_descricoes(self):
        for produto in self.carrinho:
            descricao = produto.get_descricao()
            print(descricao)


# Teste dos produtos
produto1 = Mouse("Loja A", 50.0, "Ótico, Saída USB. 1.600 dpi")
produto2 = Livro("Loja B", 30.0, "Autor: Uncle Bob")
produto3 = Mouse("Loja C", 45.0, "Bluetooth, Recarregável")

# Teste do carrinho de compras
teste_carrinho = ProdutoTeste()
teste_carrinho.adicionar_produto(produto1)
teste_carrinho.adicionar_produto(produto2)
teste_carrinho.adicionar_produto(produto3)

teste_carrinho.mostrar_descricoes()
