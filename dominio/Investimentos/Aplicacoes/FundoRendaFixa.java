package dominio.Investimentos.Aplicacoes;

import dominio.Investimentos.BensPrototype;

public class FundoRendaFixa extends BensPrototype {
	
	@Override
	public BensPrototype cloneBens() {
		return new FundoRendaFixa();
	}
	public FundoRendaFixa(){
		setName("FundoRendaFixa");
		setValorCompra(800);
		setValorVenda(800);
		setRetorno(100);
		setDespesaMensal(0);
		setImagem("resources/imagens/FundoRendaFixa.jpg");
		setIcone("resources/imagens/FundoRendaFixa_m.jpg");  
	}

}
