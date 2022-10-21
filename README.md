# Financial Strategy

## Regras
> É obrigatorio abrir uma conta corrente.
> A cada final de ciclo todas as contas correntes recebem um recurso fixo.
> Você pode fazer investimentos, sendo
>    existem contas de investimento fixo.
>        fundo de renda fixo
>        fundo imobiliário
>        poupança
>    existem contas de investimento variável.
>        ações
>        cambio
> Voce pode comprar ou vender bens, aumentando o recebimento de recursos fixos a cada ciclo.
>    Casas e apartamentos no possuiem riscos
>    Comercio possui risco moderado, a cada n ciclos pode ser ser prejuizos
>    Area rural, rende muito, mas o risco é maior

# TO DO
Quando compra a casa falta ajustar painel de bens
Falta fazer toda a parte de Investimentos
No ciclo deve calcular os rendimentos e despesas dos bens

# TO DO Regras
A partir de determinado ciclo, iniciam as despesas
    fixas: sobre o ganho de capital
    fixas: pagamento fixos mensais
    variáveis: quebra de maquinas
    variáveis: despesas médicas.


# Utilização de Padroes:
- Utilizado Builder para criação das Contas (Products)
- Utilizado Factory Method para criação das Aplicações

- Utilizado Factory Method para criação das Telas

- Utilizado Prototype para criação de Bens
- Utilizado Singleton para criação de Variaveis Globais IdentificadorDaConta - Global
- Utilizado Singleton para criação de Variaveis Globais IdentificadorMovimento - Global
- Utilizado o AbstractFactory para conectar com o Banco de Dados e oferecer as funcões de CRUD
- Utilizar o Observer para monitorar o numero de jogadas até o ciclo
- Utilizar o Observer para randomizar jogadas onde o jogador perde dinheiro


trabalho a ser apresentado : Bridge


