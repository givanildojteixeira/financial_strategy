package console;

import dominio.Operacoes;
import front.javax.FactoryMethodInterface;

public class ProcessaCiclo extends Observer {
    Operacoes o = new Operacoes();

    @Override
    public void ciclo() {
        // CREDITOS
        // salario
        o.gravaSaldoConta(o.saldoDaConta() + Global.SALARIOMENSAL);
        
        if (preliminar())
            return;
        if (vencedor())
            return;
        if (perdedor())
            return;
        usoLimite();
        

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
    public boolean dificuldade() {
        // TODO Auto-generated method stub
        return false;
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
        // TODO Auto-generated method stub

    }

    @Override
    public void pegoAleatorioPeloImpostoDeRenda() {
        // TODO Auto-generated method stub

    }

    @Override
    public void melhorJogada() {
        // TODO Auto-generated method stub

    }

    @Override
    public void piorJogada() {
        // TODO Auto-generated method stub

    }

    @Override
    public void meritoInvestidor() {
        // TODO Auto-generated method stub

    }


}