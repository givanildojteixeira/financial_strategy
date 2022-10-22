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

CRIACIONAIS
-   [x] Abstract Factory    - Utilizado o AbstractFactory para conectar com o Banco de Dados e oferecer as funcões de CRUD
-   [x] Builder             - Utilizado para criação das Contas (Products)
-   [x] Factory Method      - Utilizado para criação das Telas
-   [x] Protopype           - Utilizado para criação de Bens
-   [x] Singleton           - Utilizado para criação de Variaveis Globais 


ESTRUTURAIS
-   [ ] Adapter
-   [ ] Facade
-   [ ] Bridge
-   [ ] Decorator
-   [ ] Flyweight
-   [ ] Composite
-   [ ] Proxy

COMPORTAMENTAIS
-   [ ] Chain of Responsability
-   [ ] Command
-   [ ] Interpreter
-   [ ] Iterator
-   [ ] Mediador
-   [ ] Memento
-   [ ] Observer
-   [ ] State
-   [ ] Strategy
-   [ ] Template Method
-   [ ] Visitor


- Utilizado Template Method para criação das Aplicações
- Utilizar o Observer para monitorar o numero de jogadas até o ciclo
- Utilizar o Observer para randomizar jogadas onde o jogador perde dinheiro


trabalho a ser apresentado : Bridge



