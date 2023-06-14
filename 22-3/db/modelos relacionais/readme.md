
As chaves primárias são:

-   Categoria: CodCategoria
-   Cliente: CodCli
-   Funcionário: CodFunc
-   Fornecedor: CodFornec
-   Produto: CodProd

As chaves estrangeiras são:

-   Cliente: CodCategoria (referencia a tabela Categoria)
-   Produto: CodFornec (referencia a tabela Fornecedor)

Para garantir a integridade referencial nas situações mencionadas, o SGBD deve executar as seguintes ações:

1.  Se uma tupla é excluída na tabela Categoria:
    
    -   Verificar se existem tuplas na tabela Cliente que referenciam a categoria excluída (através da chave estrangeira CodCategoria).
    -   Se existirem, o SGBD deve executar uma das seguintes ações:
        -   Excluir as tuplas da tabela Cliente que referenciam a categoria excluída.
        -   Atribuir um valor padrão ou nulo à chave estrangeira CodCategoria nas tuplas da tabela Cliente que referenciam a categoria excluída.
        -   Gerar um erro e impedir a exclusão da categoria até que todas as referências à ela sejam removidas ou atualizadas.
2.  Se uma tupla é alterada na tabela Fornecedor:
    
    -   Verificar se existem tuplas na tabela Produto que referenciam o fornecedor alterado (através da chave estrangeira CodFornec).
    -   Se existirem, o SGBD deve atualizar o valor da chave estrangeira CodFornec nas tuplas da tabela Produto que referenciam o fornecedor alterado para refletir a nova chave primária do fornecedor.
    -   Se o valor da chave estrangeira não pode ser atualizado (por exemplo, se o novo valor não existe na tabela Fornecedor), o SGBD deve executar uma das seguintes ações:
        -   Atribuir um valor padrão ou nulo à chave estrangeira CodFornec nas tuplas da tabela Produto que referenciam o fornecedor alterado.
        -   Gerar um erro e impedir a atualização do fornecedor até que todas as referências à ele sejam atualizadas ou removidas.
