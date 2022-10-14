package dominio.Investimentos.Bens;

import dominio.Investimentos.BensPrototype;

public class Comercio extends BensPrototype {

	@Override
	public BensPrototype cloneBens() {
		return new Comercio();
	}

	public Comercio() {
		setName("Comercio");
		setValorCompra(3000);
		setValorVenda(2300);
		setRetorno(300);
		setDespesaMensal(30);
	}
}
