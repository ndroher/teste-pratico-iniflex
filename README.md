# Teste Prático - Iniflex

## Sobre

Este repositório contém a solução em Java para o desafio técnico para a vaga de Desenvolvedor de Software proposto pela Projedata.

## Requisitos Funcionais

O projeto implementa as seguintes especificações:

1. **Classe `Pessoa`** com os atributos: `nome` (String) e `dataNascimento` (LocalDate).

2. **Classe `Funcionario`** que estende `Pessoa`, com os atributos: `salario` (BigDecimal) e `funcao` (String).

3. **Classe `Principal`** que executa as seguintes ações:

   * **3.1** – Inserir todos os funcionários, na mesma ordem e com as mesmas informações da tabela.

   * **3.2** – Remover o funcionário "João" da lista.

   * **3.3** – Imprimir todos os funcionários com todas as suas informações, sendo que:

     * informação de data deve ser exibida no formato dd/mm/aaaa;

     * informação de valor numérico deve ser exibida no formato com separador de milhar como ponto e decimal como vírgula.

   * **3.4** – Aumentar o salário de todos os funcionários em 10%.

   * **3.5** – Agrupar os funcionários por função num `Map`.

   * **3.6** – Imprimir os funcionários agrupados por função.

   * **3.8** – Imprimir os funcionários que fazem aniversário nos meses 10 e 12.

   * **3.9** – Imprimir o funcionário com a maior idade, exibindo nome e idade.

   * **3.10** – Imprimir a lista de funcionários por ordem alfabética.

   * **3.11** – Imprimir o total dos salários dos funcionários.

   * **3.12** – Imprimir quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$1212.00.

## Estrutura do Projeto

```
teste-pratico-iniflex/
├── src/br/com/projedata/iniflex
│   ├── main/
│   │   └── Principal.java
│   └── models/
│       ├── Funcionario.java
│       └── Pessoa.java
└── README.md
```
