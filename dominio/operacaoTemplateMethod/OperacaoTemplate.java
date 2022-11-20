package dominio.operacaoTemplateMethod;

public abstract class OperacaoTemplate {
    
    public void comprar(double valor, String bem) {
        sacarDaConta(valor);
        gravaSaldoContaArquivo(valor);
        atualizaPatrimonio(bem);
        gravaMovimentacao("D", "Aquisição patrimonio:" + bem, valor);
    }

    public void vender(double valor, String bem) {
        depositarNaConta(valor);
        gravaSaldoContaArquivo(valor);
        atualizaPatrimonio(bem);
        gravaMovimentacao("C", "Venda patrimonio:" + bem, valor);
    }

    public abstract void sacarDaConta(double valor);
    public abstract void depositarNaConta(double valor);
    public abstract void gravaSaldoContaArquivo(double valor);
    public abstract void atualizaPatrimonio(String bem);
    public abstract void gravaMovimentacao(String DC, String texto, double valorDoBem);

}
