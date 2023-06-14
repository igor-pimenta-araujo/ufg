
#### INF0303_2022/2 - Semana 06 - Dia 30/11/2022 - Encontro 06 - Aulas 21a24 - Tarefa Prática
Igor Pimenta Araujo - 201905534

**Resolução**:

*A ordem dos valores de entrada é a seguinte: nota1, nota2, cargaHoraria, faltas*

*Casos de testes para nota1 e nota2*
|CT|n1|n2|carga horaria|faltas|Resultado Esperado|Classe Equivalência|
|--|--|--|--|--|--|--|
|CT01|-1| -1| 4| 0|Valores Inválidos|CE01, CE03, CE09, CE10|
|CT02|1| 1| 4| 0|Reprovado por Média|CE07, CE08, CE09, CE10|
|CT03|9| 9| 4| 0|Aprovado|CE07, CE08, CE09, CE10|
|CT04|10| 10| 4| 0|Aprovado|CE07, CE08, CE09, CE10|
|CT05|11| 11| 4| 0|Valores Inválidos|CE02, CE04, CE09, CE10|

*Casos de testes para faltas*
|CT|n1|n2|carga horaria|faltas|Resultado Esperado|Classe Equivalência|
|--|--|--|--|--|--|--|
|CT06|9| 9| 4| -1|Valores Inválidos|CE07, CE08, CE09, CE06|
|CT07|9| 9| 8| 0|Aprovado|CE07, CE08, CE09, CE10|
|CT08|9| 9| 8| 8|Reprovado|CE07, CE08, CE09, CE10|

*Casos de testes para cargaHoraria*
|CT|n1|n2|carga horaria|faltas|Resultado Esperado|Classe Equivalência|
|--|--|--|--|--|--|--|
|CT09|9| 9| 1| 0|Aprovado|CE07, CE08, CE09, CE10|
|CT10|9| 9| -1| 0|Valores Inválidos|CE07, CE08, CE05, CE10|
|CT11|9| 9| 0| 0|Valores Inválidos|CE07, CE08, CE05, CE10|

Onde:
**CT** = Caso de Teste, seguido de um valor sequencial;
**Valor de entrada** é o valor informado para a variável;
**Resultado esperado** é o resultado que se espera da execução da função;
**Classe de Equivalência** é a identificação de qual classe de equivalência está sendo exercitada pelo caso de teste.
