<h1 align="center"> # Financial Strategy </h1>
  
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

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


# Utilização de Padroes GOF:

CRIACIONAIS
-   [x] Abstract Factory    - Utilizado o AbstractFactory para conectar com o Banco de Dados e oferecer as funcões de CRUD
-   [x] Builder             - Utilizado para criação das Contas (Products)
-   [x] Factory Method      - Utilizado para criação das Telas
-   [x] Protopype           - Utilizado para criação de Bens e Aplicações
-   [x] Singleton           - Utilizado para criação de Variaveis Globais 


ESTRUTURAIS
-   [ ] Adapter
-   [X] Facade - Trabalha junto com o ciclo, processando os valores de credito e de debito originarios do patrimonio, centraliza a varredura de bens e aplicações, retornando o valor de receita ou despesa.(Arquivos: pasta facade)
-   [X] Bridge - Para gerenciador de Relatorios, onde é possivel ver qualquer relatorio dentro de qualquer visualizador (Arquivos usados: BridgeRelatorios + VisualizadorDeRelatorios + GeradorDeRelatorios)
-   [x] Decorator - Usado para acrescentar uma codificação a informação que será lida ou gravada no arquivo FileConfig, para que ela nao seja gravada como texto puro podendo ser alterada manualmente. (Arquivos usados: Base64Decorator + FileConfigDecorator)
-   [ ] Flyweight
-   [ ] Composite
-   [ ] Proxy

COMPORTAMENTAIS
-   [X] Chain of Responsability - Recebe o pedido de gravação pelo DBProperties e faz uma OrdemResponsabilidade para gravar no arquivo correto com base na lista em IdFiles (Arquivos usados: FileChain, IdFiles, FileConfig e FileMovimento)
-   [ ] Command
-   [ ] Interpreter
-   [ ] Iterator
-   [ ] Mediador
-   [ ] Memento
-   [X] Observer - Fica escondido atras do Ciclo, observando com a ajuda do Oraculo varios acontecimentos dentro do programa e tomando açoes conforme orientado (Arquivos: Observer, Oraculo, ProcessaCiclo)
-   [ ] State
-   [X] Strategy - Gerenciador do grau de dificuldade do jogo, inicialmente setado no Global como GrauDeDiculdade, e gerenciado pelo arquivo Strategy.java, que tem sua interface no arquivo GrauDeDiculdade, reduzindo o valor da conta corrente confirme a estrategia (Arquivos: Strategy, GrauDeDificuldade e demais arquivos na pasta estrategia)
-   [ ] Template Method
-   [ ] Visitor





