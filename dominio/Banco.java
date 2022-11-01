package dominio;

import java.util.*;
import console.Ferramentas;
// import dominio.Investimentos.BensPrototype;

public class Banco {
	private static Map<String, ContaProduct> contas = new HashMap<String, ContaProduct>();

	public Banco() {
	}

	public void insereConta(ContaProduct conta) {
		contas.put(conta.getNome(), conta);
		
	}

	public static ContaProduct getConta(String nome) {
		return contas.get(nome);
	}

	public void removerConta(ContaProduct conta) {
		contas.remove(conta.getNome());
	}

    public static String nomeDoCliente(int nroConta) {
		for (String key : contas.keySet()) {
            if (contas.get(key).getNumero() == nroConta) {
                return contas.get(key).getNome();
            }
		}
		return "";
	}


	public  String listaContas() {
		String ct = ""; 
			Ferramentas f = new Ferramentas();
		ct += "-------------------------------------------------------------------------\n";
		for (String key : contas.keySet()) {
			ct += String.format("|%03d|",contas.get(key).getNumero()) + " - " + 
            String.format("%-20s", contas.get(key).getTipoAbreviado() +  contas.get(key).getNome() ) +
            " - Saldo R$ " + f.cMB(contas.get(key).getSaldo()) + 
            " - Limite R$ " + f.cMB(contas.get(key).getLimite()) + "\n";
		}
		return ct += "-------------------------------------------------------------------------\n";
	}

	ArrayList<Movimentacao> movimento = new ArrayList<Movimentacao>();
	// ArrayList<BensPrototype> bens = new ArrayList<BensPrototype>();
	// ArrayList<BensPrototype> aplicacoes = new ArrayList<BensPrototype>();


	public void InsereMovimentacao(Movimentacao m){
		movimento.add(m);
	}

 
}