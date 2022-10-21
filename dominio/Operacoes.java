package dominio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Relatorios.Extratos;
import bancoDados.Connector;
import console.Global;
import dominio.Investimentos.BensCache;
import dominio.Investimentos.BensPrototype;
import dominio.Products.ContaAdministrador;
import dominio.Products.ContaCorrente;
import dominio.Products.ContaPro;

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

	public void GravarDBValor(String chave, Double valor) {
		Connector.gravar(chave, String.valueOf(valor));
	}

	public String leDB(String chave) {
		return Connector.le(chave);
	}

	public double leDBValor(String chave) {
		return Double.parseDouble(Connector.le(chave));
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

	public boolean sacar(double valor, String descricao) {
		// ContaProduct cliente = c.getConta(Global.USUARIO);
		if (c.getConta().sacar(valor) == true) {
			b.movimento.add(new Movimentacao(c.getConta().getNumero(), "D", descricao, valor));
			return true;
		} else {
			return false;
		}
	}

	public boolean depositar(double valor, String descricao) {
		c.getConta().depositar(valor);
		b.movimento.add(new Movimentacao(c.getConta().getNumero(), "C", descricao, valor));
		return true;
	}

	public String extrato(int nroConta) {
		ContaProduct cliente = c.getConta(Global.USUARIO);
		return (e.getExtrato(cliente));
	}

	public double saldoDaConta() {
		return c.getConta().getSaldo();
	}

	public void gravaSaldoConta(double v) {
		c.getConta().setSaldo(v);
		GravarDBValor(Global.USUARIO + "-s", v);
	}

	public void gravaLimiteConta(double v) {
		c.getConta().setLimite(v);
		GravarDBValor(Global.USUARIO + "-l", v);
	}

	public double limiteDaConta() {
		return c.getConta().getLimite();
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

	public void ciclo() {
		/*
		 * Adiciona um valor para cada conta para aumentar o capital
		 * contas Pro recebem um bonus
		 * contas Adm nao recebem nada
		 */
		System.out.println("Ciclo de contas Iniciado");
		// soma o salário ao saldo
		gravaSaldoConta(saldoDaConta() + 300);

	}

	public void pesquisaBens() {

		// BensCache.loadForms();
		// BensPrototype casa;
		// BensPrototype apartamento = BensCache.getForm(BensPrototype.Apartamento);

		// System.out.println(casa.getPesquisa());
		// System.out.println(apartamento.getPesquisa());

		// Apartamento apartamento = new Apartamento();
		// BensCache.loadBens(BensPrototype.Apartamento, apartamento);
		// bem = BensCache.getForm(BensPrototype.Apartamento);
		// System.out.println(bem.getPesquisa());
	}

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
		} else {
			return false;
		}
		return true;
	}

	public void atualizaBensUsuario(String bem) {
		double q = 0.0, r = 0.0, d = 0.0;
		try {
			q = leDBValor(Global.USUARIO + "-" + bem + "-Quant");
			r = leDBValor(Global.USUARIO + "-" + bem + "-Retorno");
			d = leDBValor(Global.USUARIO + "-" + bem + "-Despesa");

			GravarDBValor(Global.USUARIO + "-" + bem + "-Quant", q + 1);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Retorno", r + retornoDoBem(bem));
			GravarDBValor(Global.USUARIO + "-" + bem + "-Despesa", d + despesaDoBem(bem));

		} catch (Exception e) {
			GravarDBValor(Global.USUARIO + "-" + bem + "-Quant", q + 1);
			GravarDBValor(Global.USUARIO + "-" + bem + "-Retorno", r + retornoDoBem(bem));
			GravarDBValor(Global.USUARIO + "-" + bem + "-Despesa", d + despesaDoBem(bem));
		}
		atualizaQuantidadeBem(bem, (int) (q + 1));
	}

	public String calcularDiferencaHoras(String horaInicial, String horaFinal) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		try {
			LocalDateTime dt1 = LocalDateTime.parse(horaInicial, f);
			LocalDateTime dt2 = LocalDateTime.parse(horaFinal, f);

			// long diferencaMili = Duration.between(dt1, dt2).toMillis();
			long ds = Duration.between(dt1, dt2).getSeconds() - (Duration.between(dt1, dt2).toMinutes() * 60);
			long dm = Duration.between(dt1, dt2).toMinutes();
			long dh = Duration.between(dt1, dt2).toHours();
			return String.format("%02d:%02d:%02d", dh, dm, ds);

		} catch (Exception ex) {
			return ("");
		}
	}

}
