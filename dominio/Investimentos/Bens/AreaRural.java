package dominio.Investimentos.Bens;

import dominio.Investimentos.BensPrototype;

public class AreaRural extends BensPrototype {
	
	@Override
	public BensPrototype cloneBens() {
		return new AreaRural();
	}
	public AreaRural(){
		setName("Area Rural");
		setValorCompra(5000);
		setValorVenda(3000);
		setRetorno(500);
		setDespesaMensal(100);
	}
}
