package dominio;

public class Director {

	private ContaBuilder contaBuilder;
	public void setContaBuilder(ContaBuilder contaBuilder) {
		this.contaBuilder = contaBuilder;
	}

	public ContaProduct getConta() {
		return contaBuilder.getConta();
	}

	public ContaProduct getConta(String cliente) {
		return contaBuilder.getConta(cliente);
	}

	public void constructConta(String nome) {
		contaBuilder.createNewContaProduct(nome);
		contaBuilder.buildSaldo();
		contaBuilder.buildLimite();
		contaBuilder.buildTipo();
		contaBuilder.buildTipoAbreviado();
		contaBuilder.buildEspecial();
	}

	public String listaContas(){
		return contaBuilder.ListeContas();
	}
	
	public boolean CicloContas() throws Exception{
		return contaBuilder.CicloContas();
	}


	// public String getConta(int nroConta) {
	// 	return contaBuilder.getConta(nroConta);
	// }

}
