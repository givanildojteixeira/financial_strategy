package dominio;

import bancoDados.Connector;
import bancoDados.dbPropertiesFiles.IdFiles;
import console.Ferramentas;
import console.Global;
import dominio.Investimentos.BensCache;
import dominio.Investimentos.BensPrototype;
import dominio.Products.ContaAdministrador;
import dominio.Products.ContaCorrente;
import dominio.Products.ContaPro;

public class Operacoes {
	Director c = new Director();
	Banco b = new Banco();
	Connector db = new Connector();
	Ferramentas f  = new Ferramentas();

	/*
	 * =====> Operações com o Banco de Dados
	 */

	public void ConectarDB(String banco, IdFiles id) {
		db.connectar(banco, id);
	}

	public void GravarDB(String chave, String valor, IdFiles id) {
		Connector.gravar(chave, valor, id);
	}

	public void GravarDBValor(String chave, Double valor, IdFiles id) {
		Connector.gravar(chave, String.valueOf(valor), id);
	}

	public String leDB(String chave, IdFiles id) {
		return Connector.le(chave, id);
	}

	public double leDBValor(String chave, IdFiles id) {
		String v = Connector.le(chave, id);
		if (v == null) {
			return 0;
		}
		return Double.parseDouble(v);
	}

	/*
	 * =====> Operações com a conta do Investidor
	 */

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
		// System.out.println("Conta " + c.getConta().getNumero() + " Criada com
		// sucesso!");
	}

	public String ListaContas() {
		return (c.listaContas());
	}

	public int getNroconta() {
		return 1;

	}

	public String getCliente() {
		return Global.USUARIO;
	}

	public String getEstpecial() {
		return "NAO";
	}

	public String getTipo() {
		return "NORMAL";
	}

	public double getSaldo() {
		return leDBValor(Global.USUARIO + "-s", IdFiles.FileConfig);
	}

	public double getLimite() {
		return leDBValor(Global.USUARIO + "-l", IdFiles.FileConfig);
	}

	// public String extrato(int nroConta) {
	// ContaProduct cliente = c.getConta(Global.USUARIO);
	// return (e.getExtrato(cliente));
	// }

	public double saldoDaConta() {
		return c.getConta().getSaldo();
	}

	public double limiteDaConta() {
		return c.getConta().getLimite();
	}

	/*
	 * =====> Operações de movimentação da Conta
	 */

	public void gravaSaldoConta(double v) {
		c.getConta().setSaldo(v);
		GravarDBValor(Global.USUARIO + "-s", v, IdFiles.FileConfig);
	}

	public void gravaLimiteConta(double v) {
		c.getConta().setLimite(v);
		GravarDBValor(Global.USUARIO + "-l", v, IdFiles.FileConfig);
	}

	public boolean depositar(double valor, String descricao) {
		c.getConta().depositar(valor);
		gravaMovimentacao("C", descricao, valor);
		b.movimento.add(new Movimentacao(c.getConta().getNumero(), "C", descricao, valor));

		// valor));
		return true;
	}

	public boolean sacar(double valor, String descricao) {
		// ContaProduct cliente = c.getConta(Global.USUARIO);
		if (c.getConta().sacar(valor) == true) {
			gravaMovimentacao("D", descricao, valor);
			// b.movimento.add(new Movimentacao(c.getConta().getNumero(), "D", descricao,
			// valor));
			return true;
		} else {
			return false;
		}
	}

	public void gravaMovimentacao(String debitoCredito, String descricao, double valor) {
		b.movimento.add(new Movimentacao(c.getConta().getNumero(), debitoCredito, descricao, valor));
		// GRAVA NO ARQUIVO
		GravarDB(Global.USUARIO + "-MOV-", debitoCredito + "-" + descricao + " - R$ " + valor, IdFiles.FileMovimento);
	}

	// public void transferir(int contaOrigem, int contaDestino, double valor) {
	// try {
	// if (sacar(contaOrigem, valor, "Transferencia")) {
	// depositar(contaDestino, valor, "Transferencia");
	// System.out.println("Transferência de [" + contaOrigem + "] para [" +
	// contaDestino + "] no valor de R$ "
	// + valor + " processada com sucesso!");
	// } else {
	// System.out.println("Não foi possivel efetuar a transferencia!");
	// }
	// } catch (Exception e) {
	// System.out.println((e.getMessage()));
	// }
	// }

	// public boolean sacar(int nroConta, double valor, String descricao) throws
	// Exception {
	// try {
	// String cliente = c.getConta(nroConta);
	// if (cliente.equals("")) {
	// throw new Exception("Conta nao existe!");
	// } else {
	// System.out.println(c.getConta(cliente).sacar(valor, descricao));
	// b.movimento.add(new Movimentacao(nroConta, "D", descricao, valor));
	// return true;
	// }
	// } catch (Exception e) {
	// System.out.println("Saque não efetuado:" + e.getMessage());
	// return false;
	// }
	// }

	// public void depositar(int nroConta, double valor, String descricao) throws
	// Exception {
	// try {
	// String cliente = c.getConta(nroConta);
	// if (cliente.equals(""))
	// throw new Exception(("Conta nao existe!"));
	// System.out.println(c.getConta(cliente).depositar(valor, descricao));
	// b.movimento.add(new Movimentacao(nroConta, "C", descricao, valor));
	// } catch (Exception e) {
	// System.out.println("Saque não efetuado:" + e.getMessage());
	// }
	// }

	// public void extrato(int nroConta) {
	// try {
	// String cliente = c.getConta(nroConta);
	// if (cliente.equals(""))
	// throw new Exception(("Conta nao existe!"));
	// System.out.println(e.getExtrato(c.getConta(cliente)));
	// } catch (Exception e) {
	// System.out.println("Saque não efetuado:" + e.getMessage());
	// }
	// }

	// public double saldoConta(int nroConta) {
	// String cliente = c.getConta(nroConta);
	// double saldo = c.getConta(cliente).getSaldo();
	// return saldo;
	// }

	/*
	 * =====> Operações do jogo para o Ciclo
	 */

	public void ciclo() {
		/*
		 * Adiciona um valor para cada conta para aumentar o capital
		 * contas Pro recebem um bonus
		 * contas Adm nao recebem nada
		 */
		// soma o salário ao saldo
		gravaSaldoConta(saldoDaConta() + 300);

	}

	/*
	 * =====> Operações com os bens/ aplicações
	 */

	public double valorCompraBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getValorCompra();
	}

	public double valorVendaBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getValorVenda();
	}

	public String nomeDoBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getName();
	}

	public String imagemDoBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getImagem();
	}

	public String iconeDoBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getIcone();
	}

	public double retornoDoBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getRetorno();
	}

	public double despesaDoBem(String qual) {
		BensCache.loadForms();
		BensPrototype ben = BensCache.getForm(qual);
		return ben.getDespesaMensal();
	}

	public void atualizaQuantidadeBem(String qual, int quant) {
		switch (qual) {
			case "Casa":
				Global.CASA = quant;
				break;
			case "Apartamento":
				Global.APARTAMENTO = quant;
				break;
			case "Comercio":
				Global.COMERCIO = quant;
				break;
			case "Fazenda":
				Global.FAZENDA = quant;
				break;
			case "Acoes":
				Global.ACOES = quant;
				break;
			case "FundoImobiliario":
				Global.FUNDOIMOBILIARIO = quant;
				break;
			case "FundoRendaFixa":
				Global.FUNDORENDAFIXA = quant;
				break;
			case "Poupanca":
				Global.POUPANCA = quant;
				break;
		}
	}

	public int getQuantidadeBem(String qual) {
		switch (qual) {
			case "Casa":
				return Global.CASA;
			case "Apartamento":
				return Global.APARTAMENTO;
			case "Comercio":
				return Global.COMERCIO;
			case "Fazenda":
				return Global.FAZENDA;
			case "Acoes":
				return Global.ACOES;
			case "FundoImobiliario":
				return Global.FUNDOIMOBILIARIO;
			case "FundoRendaFixa":
				return Global.FUNDORENDAFIXA;
			case "Poupanca":
				return Global.POUPANCA;
		}
		return 0;
	}

	public boolean comprarBens(String bem) {
		// tem saldo?
		double valorDoBem = valorCompraBem(bem);
		if (saldoDaConta() >= valorDoBem) {
			sacar(valorDoBem, "Compra de " + bem);
			gravaSaldoConta(saldoDaConta());
			atualizaBensUsuario(bem);
			gravaMovimentacao("D", "Compra de " + bem, valorDoBem);
		} else {
			return false;
		}
		return true;
	}

	public void atualizaBensUsuario(String bem) {
		double q = 0.0, r = 0.0, d = 0.0;
		try {
			q = leDBValor(Global.USUARIO + "-" + bem + "-Quant", IdFiles.FileConfig);
			r = leDBValor(Global.USUARIO + "-" + bem + "-Retorno", IdFiles.FileConfig);
			d = leDBValor(Global.USUARIO + "-" + bem + "-Despesa", IdFiles.FileConfig);

			GravarDBValor(Global.USUARIO + "-" + bem + "-Quant", q + 1, IdFiles.FileConfig);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Retorno", r + retornoDoBem(bem), IdFiles.FileConfig);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Despesa", d + despesaDoBem(bem), IdFiles.FileConfig);

		} catch (Exception e) {
			GravarDBValor(Global.USUARIO + "-" + bem + "-Quant", q + 1, IdFiles.FileConfig);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Retorno", r + retornoDoBem(bem), IdFiles.FileConfig);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Despesa", d + despesaDoBem(bem), IdFiles.FileConfig);
		}
		atualizaQuantidadeBem(bem, (int) (q + 1));
	}
	public String QualificaBem(String q) {
		String r;
		if (getQuantidadeBem(q) > 0) {
			r = "["
					+ getQuantidadeBem(q)
					+ "] Cash R$ " + f.cMB(getQuantidadeBem(q) * retornoDoBem(q))
					+ " Desp R$ " + f.cMB(getQuantidadeBem(q) * despesaDoBem(q));

		} else {
			r = "Você ainda não adquiriu esse item!";
		}

		return r;
	}

}
