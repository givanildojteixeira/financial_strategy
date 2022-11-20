package dominio.operacaoTemplateMethod;

import dominio.Operacoes;

public class financeiro extends OperacaoTemplate {
    Operacoes o = new Operacoes();

    @Override
    public void sacarDaConta(double valor) {
        o.sacar(valor);
    }

    @Override
    public void depositarNaConta(double valor) {
        o.depositar(valor);
    }

    @Override
    public void gravaSaldoContaArquivo(double valor) {
        o.gravaSaldoConta(valor);
    }

    @Override
    public void atualizaPatrimonio(String bem) {
        o.atualizaBensUsuario(bem);
    }

    @Override
    public void gravaMovimentacao(String DC, String texto, double valorDoBem) {
        o.gravaMovimentacao(DC, texto, valorDoBem);
    }

}
