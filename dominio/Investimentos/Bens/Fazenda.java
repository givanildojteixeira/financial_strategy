package dominio.Investimentos.Bens;

import dominio.Investimentos.BensPrototype;

public class Fazenda extends BensPrototype {
	
	@Override
	public BensPrototype cloneBens() {
		return new Fazenda();
	}
	public Fazenda(){
		setName("Fazenda");
		setValorCompra(5000);
		setValorVenda(3000);
		setRetorno(500);
		setDespesaMensal(100);
		setImagem("resources/imagens/Fazenda.jpg");
		setIcone("resources/imagens/Fazenda_m.jpg");
	}
}
