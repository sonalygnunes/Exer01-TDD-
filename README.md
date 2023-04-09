# Filtro de Fatura (TDD)
## _Exercício para displicina de Validação e Verificação de Software no curso de Ciência da Computação_

Deve-se implementar um filtro de faturas. Uma fatura contém um código, um valor, uma data, e pertence a um cliente. Um cliente tem um nome, data de inclusão e um estado.

O filtro deverá então, dado uma lista de faturas, remover as que se encaixam em algum dos critérios
abaixo:

- Se o valor da fatura for menor que 2000;
- Se o valor da fatura estiver entre 2000 e 2500 e a data for menor ou igual a de um mês atrás;
- Se o valor da fatura estiver entre 2500 e 3000 e a data de inclusão do cliente for menor ou igual a 2 meses atrás;
- Se o valor da fatura for maior que 4000 e pertencer a algum estado da região Sul do Brasil.

# Foco
- Aplicar todos os passos de TDD
- Criar projetos de classes  elegantes.
- Desenvolvimento considerando que o código poderá sofrer manutenções futuras feitas por uma equipe. O código deve ser flexível o suficiente para que novas mudanças sejam fáceis de serem implementadas.

# Autores
Esse filtro de faturas foi desenvolvido por Sonaly Nunes e Hiago Lacerda como um projeto de [disciplina/necessidade/projeto pessoal/etc.].
