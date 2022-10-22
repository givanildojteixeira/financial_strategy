package dominio.Investimentos.Aplicacoes;

import dominio.Investimentos.BensPrototype;

public class Poupanca extends BensPrototype {

    @Override
    public BensPrototype cloneBens() {
        return new Poupanca();
    }

    public Poupanca() {
        setName("Poupanca");
        setValorCompra(100);
        setValorVenda(100);
        setRetorno(10);
        setDespesaMensal(0);
		setImagem("resources/imagens/Poupanca.jpg");
		setIcone("resources/imagens/Poupanca_m.jpg");
    }
}
