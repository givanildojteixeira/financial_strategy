package dominio.Investimentos;

import console.Ferramentas;

public abstract class BensPrototype {
	private String name;
	private double valorCompra;
	private double valorVenda;
	private double retorno;
	private double despesaMensal;
	private String imagem;
	private String icone;

	public abstract BensPrototype cloneBens();

	public static final String ACOES = "Acoes";
	public static final String FUNDOIMOBILIARIO = "FundoImobiliario";
	public static final String FUNDORENDAFIXA = "FundoRendaFixa";
	public static final String POUPANCA = "Poupanca";

	public static final String APARTAMENTO = "Apartamento";
	public static final String FAZENDA = "Fazenda";
	public static final String CASA = "Casa";
	public static final String COMERCIO = "Comercio";

	Ferramentas f = new Ferramentas();

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getValorCompra() {
		return this.valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return this.valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getRetorno() {
		return this.retorno;
	}

	public void setRetorno(double retorno) {
		this.retorno = retorno;
	}

	public double getDespesaMensal() {
		return this.despesaMensal;
	}

	public void setDespesaMensal(double despesaMensal) {
		this.despesaMensal = despesaMensal;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getPesquisa() {
		return "Nome do Investimento: " + (getName()) + "\n" +
				"Valor Compra      R$: " + f.cMB(getValorCompra()) + "\n" +
				"Valor Venda       R$: " + f.cMB(getValorVenda()) + "\n" +
				"Retorno           R$: " + f.cMB(getRetorno()) + "\n" +
				"Despesa Mensal    R$: " + f.cMB(getDespesaMensal()) + "\n";
	}

}
