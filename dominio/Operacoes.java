package dominio;

import dominio.Products.ContaAdministrador;
import dominio.Products.ContaCorrente;
import dominio.Products.ContaPro;
import Relatorios.Extratos;
import bancoDados.Connector;
import console.Global;
import dominio.Investimentos.*;

public class Operacoes {
	Director c = new Director();
	Banco b = new Banco();
	Extratos e = new Extratos();
	Connector db = new Connector();
	// ContaProduct cliente = c.getConta(Global.USUARIO);

	public void ConectarDB(String banco) {
		db.connectar(banco);
	}

	public void GravarDB(String chave, String valor) {
		Connector.gravar(chave, valor);
	}

	public String leDB(String chave) {
		return Connector.le(chave);
	}

	public void CriarConta(String cliente, String tipo) {
		switch (tipo) {
			case "Pro":
				c.setContaBuilder(new ContaPro());
				break;
			case "Administrador":
				c.setContaBuilder(new ContaAdministrador());
				break;
			default:
				c.setContaBuilder(new ContaCorrente());
		}
		c.constructConta(cliente);
		System.out.println("Conta " + c.getConta().getNumero() + " Criada com sucesso!");
	}

	public void ListaContas() {
		System.out.println(c.listaContas());
	}

	// public void transferir(int contaOrigem, int contaDestino, double valor) {
	// 	try {
	// 		if (sacar(contaOrigem, valor, "Transferencia")) {
	// 			depositar(contaDestino, valor, "Transferencia");
	// 			System.out.println("Transferência de [" + contaOrigem + "] para [" + contaDestino + "] no valor de R$ "
	// 					+ valor + " processada com sucesso!");
	// 		} else {
	// 			System.out.println("Não foi possivel efetuar a transferencia!");
	// 		}
	// 	} catch (Exception e) {
	// 		System.out.println((e.getMessage()));
	// 	}
	// }

	public String sacar(double valor, String descricao) {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		if (cliente.sacar(valor)==true){
			b.movimento.add(new Movimentacao(cliente.getNumero(), "D", descricao, valor));
			return "Saque efetuado com sucesso! Verifique seu saldo";
		}else{
			return "Saque não pode ser efetuado, verifique o seu saldo e tente novamente!";
		}
	}

	public String depositar(double valor, String descricao) {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		cliente.depositar(valor, descricao);
		b.movimento.add(new Movimentacao(cliente.getNumero(), "C", descricao, valor));
		return "Deposito efetuado com sucesso! Verifique seu saldo";
	}

	public String extrato(int nroConta) {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		return (e.getExtrato(cliente));
	}

	public double saldoDaConta() {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		return (double) cliente.getSaldo();
	}

	public double limiteDaConta() {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		return (double) cliente.getLimite();
	}

	public void ciclo() throws Exception {
		/*
		 * Adiciona um valor para cada conta para aumentar o capital
		 * contas Pro recebem um bonus
		 * contas Adm nao recebem nada
		 */
		System.out.println("Ciclo de contas Iniciado");
		c.CicloContas();

	}

	public void pesquisaBens() {

		// BensCache.loadForms();
		// BensCache.loadBens(null, null);
		// BensPrototype casa;
		// BensPrototype apartamento = BensCache.getForm(BensPrototype.Apartamento);

		// System.out.println(casa.getPesquisa());
		// System.out.println(apartamento.getPesquisa());

		// Apartamento apartamento = new Apartamento();
		// BensCache.loadBens(BensPrototype.Apartamento, apartamento);
		// bem = BensCache.getForm(BensPrototype.Apartamento);
		// System.out.println(bem.getPesquisa());

	}

	public boolean comprarBens(String bem) throws Exception {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(BensPrototype.CASA);

		switch (bem) {
			case "Casa":
				ben = BensCache.getForm(BensPrototype.CASA);
				break;
			case "Apartamento":
				ben = BensCache.getForm(BensPrototype.APARTAMENTO);
				break;
			case "Comercio":
				ben = BensCache.getForm(BensPrototype.COMERCIO);
				break;
			case "AreaRural":
				ben = BensCache.getForm(BensPrototype.AREARURAL);
				break;
		}

		double valorDoBem = ben.getValorCompra();

		// tem saldo?
		if (saldoDaConta() >= valorDoBem) {
			sacar(valorDoBem, "Compra de uma casa!");
		} else {
			throw new Exception(("Nao há saldo para compra da Casa!"));
		}

		return true;
	}

}
