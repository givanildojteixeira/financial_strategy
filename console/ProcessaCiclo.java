package console;

import console.estrategia.Strategy;
import console.facade.SistemaFacade;
import dominio.Operacoes;
import front.javax.FactoryMethodInterface;

public class ProcessaCiclo extends Observer {
    Operacoes o = new Operacoes();
    Strategy s = new Strategy(Global.GRAUDEDIFICULDADE);

    @Override
    public void ciclo() {

        // CREDITOS E DEBITOS
        SistemaFacade fachada = new SistemaFacade();
        double receitas = fachada.analiseReceitas();
        double despesas = fachada.analiseDespesas();
        
        o.gravaSaldoConta(o.saldoDaConta() + receitas);
        o.gravaSaldoConta(o.saldoDaConta() - despesas);
        System.out.println("Receitas " + receitas);
        System.out.println("Despesas " + despesas);

        // salario
        o.gravaSaldoConta(o.saldoDaConta() + Global.SALARIOMENSAL);

        // Oraculo
        if (preliminar())
            return;
        if (vencedor())
            return;
        if (perdedor())
            return;

        // avisos
        usoLimite();

        // aplica a dificuldade referente a analise do mercado atual
        dificuldade();

        // mostra o resultado na tela
        // FactoryMethodInterface.getMensagem(
        //     true,
        //     "Novo Ciclo",
        //     "Novo Período!",
        //     "Seus Rendimentos foram R$ " + receitas + " E suas despesas foram R$ " + despesas,
        //     "Você está no caminho certo! ",
        //     "");

    }

    @Override
    public boolean preliminar() {
        // controla fase inicial do jogo, nao prejudicando o usuario no inicio
        Global.jogadasPreliminares--;
        if (Global.jogadasPreliminares < 0)
            return false;
        return true;
    }

    @Override
    public void dificuldade() {
        System.out.println("Valor Dificuldade " + s.calcularValorPerdido());
        o.gravaSaldoConta(o.saldoDaConta() - s.calcularValorPerdido());
    }

    @Override
    public boolean usoLimite() {
        // Avise o jogador que ele está usando o limite
        if (o.saldoDaConta() <= 0)
            FactoryMethodInterface.getMensagem(
                    false,
                    "Atenção",
                    "Muito cuidado!!",
                    "Você esta usando Limite Especial",
                    "O uso prolongado de limite poderá te levar as ruinas! ",
                    "");
        return false;
    }

    @Override
    public boolean vencedor() {
        // É declarado vencedor quando atingir um valor predefinido
        if (o.saldoDaConta() >= Global.VALORVENCEDOR) {
            FactoryMethodInterface.getMensagem(
                    true,
                    "Fim de jogo",
                    "Parabéns! Você Foi o Vencedor!!",
                    "Você alcançou o sucesso!",
                    "Você ja pode contar para seus amigos que zerou o jogo!!",
                    "");
            return true;
        }
        return false;
    }

    @Override
    public boolean perdedor() {
        // se usar todo o limite perde o jogo
        if (o.limiteDaConta() <= 0) {
            FactoryMethodInterface.getMensagem(
                    false,
                    "Fim de jogo",
                    "Que pena! Você Perdeu!!",
                    "Não foi dessa vez!",
                    "Tente novamente, na proxima terá mais chances!",
                    "");
            return true;
        }
        return false;
    }

    @Override
    public void extraPorTempoJogando() {
        // jogaor ganha bonus se ultrapassar um tempo jogando

    }

    @Override
    public void pegoAleatorioPeloImpostoDeRenda() {
        // vai ser fiscalizado 

    }

    @Override
    public void melhorJogada() {
        // jogada que mais deu rendimento

    }

    @Override
    public void piorJogada() {
        // jogada com pior rendimento

    }

    @Override
    public void meritoInvestidor() {
        // grande capacidade de investimento

    }


}
