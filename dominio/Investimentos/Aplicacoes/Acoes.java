package dominio.Investimentos.Aplicacoes;

import dominio.Investimentos.BensPrototype;

public class Acoes extends BensPrototype {
	
	@Override
	public BensPrototype cloneBens() {
		return new Acoes();
	}
	public Acoes(){
		setName("Acoes");
		setValorCompra(10);
		setValorVenda(5);
		setRetorno(1);
		setDespesaMensal(0);
		setImagem("resources/imagens/Acoes.jpg");
		setIcone("resources/imagens/Acoes_m.jpg");
	}


}

