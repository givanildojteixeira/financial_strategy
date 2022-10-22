package dominio.Investimentos.Aplicacoes;

import dominio.Investimentos.BensPrototype;

public class FundoImobiliario extends BensPrototype {

    @Override
    public BensPrototype cloneBens() {
        return new FundoImobiliario();
    }

    public FundoImobiliario() {
        setName("FundoImobiliario");
        setValorCompra(1000);
        setValorVenda(1000);
        setRetorno(500);
        setDespesaMensal(0);
		setImagem("resources/imagens/FundoImobiliario.jpg");
		setIcone("resources/imagens/FundoImobiliario_m.jpg");
    }

}
