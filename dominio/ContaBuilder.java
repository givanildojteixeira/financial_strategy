package dominio;

public abstract class ContaBuilder {
	protected ContaProduct conta;
	static Banco banco = new Banco();
	
	public abstract void buildSaldo();
	public abstract void buildLimite();
	public abstract void buildTipo();
	public abstract void buildEspecial();
	public abstract void buildTipoAbreviado();

	public ContaProduct getConta(){
		return conta;
	}

	public ContaProduct getConta(String nome){
		return Banco.getConta(nome);
	}

	public void createNewContaProduct(String string){
		conta = new ContaProduct(string);
		//grava a conta no banco
		banco.insereConta(conta);
	}
	

	public String ListeContas(){
		return (banco.listaContas());
	}

	public boolean CicloContas() throws Exception{
		return banco.CicloContas();
	}

	public String getConta(int nroConta) {
		return Banco.nomeDoCliente(nroConta);
	}
}

