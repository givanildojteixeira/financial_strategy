package dominio.Investimentos;

import console.Ferramentas;

public abstract class BensPrototype {
    private String name;
	private double valorCompra;
	private double valorVenda;
	private double retorno;
	private double despesaMensal;

	public abstract BensPrototype cloneBens();
	
	public static final String APARTAMENTO = "Apartamento";
	public static final String FAZENDA = "Fazenda";
	public static final String CASA = "Casa";
    public static final String COMERCIO = "Comercio";

	public String getName() {
		return name;
	}

	public String getPesquisa(){
		return 
		"Nome do Investimento: "  + (getName()) + "\n" +
		"Valor Compra      R$: "  + Ferramentas.cMB(getValorCompra()) + "\n" +
		"Valor Venda       R$: "  + Ferramentas.cMB(getValorVenda()) + "\n" +
		"Retorno           R$: "  + Ferramentas.cMB(getRetorno()) + "\n" +
		"Despesa Mensal    R$: "  + Ferramentas.cMB(getDespesaMensal()) + "\n";
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
}
