package dominio.Investimentos.Bens;

import dominio.Investimentos.BensPrototype;

public class Casa extends BensPrototype {
	
	@Override
	public BensPrototype cloneBens() {
		return new Casa();
	}
	public Casa(){
		setName("Casa");
		setValorCompra(1000);
		setValorVenda(800);
		setRetorno(100);
		setDespesaMensal(10);
	}
}
