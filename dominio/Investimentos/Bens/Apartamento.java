package dominio.Investimentos.Bens;

import dominio.Investimentos.BensPrototype;

public class Apartamento extends BensPrototype {

	@Override
	public BensPrototype cloneBens() {
		return new Apartamento();
	}

	public Apartamento() {
		setName("Apartamento");
		setValorCompra(2000);
		setValorVenda(1500);
		setRetorno(200);
		setDespesaMensal(20);
		setImagem("resources/imagens/Apartamento.jpg");
		setIcone("resources/imagens/Apartamento_m.jpg");
	}

}
