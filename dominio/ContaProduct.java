package dominio;

import console.Global;

public class ContaProduct {

	private int numero;
	private String nome;
	private double saldo;
	private double limite;
	private String tipo;
	private String tipoAbreviado;
	private boolean especial;

	Global.IdentificadorConta idcta = Global.IdentificadorConta.getInstance();

	public ContaProduct() {

	}

	public ContaProduct(String nome) {
		this.nome = nome;
		this.numero = idcta.novo();
	}

	public int getNumero() {
		return this.numero;
	}

	public String getNome() {
		return this.nome;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return this.limite;
	}

	public void setLimite(double limite) {
		if (limite >= 0) {
			this.limite = limite;
		} else {
			throw new IllegalArgumentException("Limite não pode ser negativo.");
		}
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEspecial() {
		return this.especial;
	}

	public String getEspecial() {
		if (especial == true) {
			return "SIM";
		}
		return "NAO";
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public String getTipoAbreviado() {
		return tipoAbreviado;
	}

	public void setTipoAbreviado(String tipoAbreviado) {
		this.tipoAbreviado = tipoAbreviado;
	}

	@Override
	public String toString() {
		return "ContaCorrente \n[numero=" + numero + ", nome=" + nome + ", saldo=" + saldo
				+ "limite=  " + limite + ", especial=" + especial + "]\n";
	}

	public String depositar(double valor, String descricao) {
		if (valor > 0) {
			if (descricao.equals(""))
				descricao = "Depósito";
			saldo += valor;
			return "Conta: [" + getNumero() + "] depósito no valor de R$ " + valor + " processado com sucesso!";

		} else {
			return "Não foi possível depositar. Esse valor não é válido.";
		}
	}

	public boolean sacar(double valor) {
		if (valor > 0) {
			if (valor > (getSaldo() + getLimite())) {
				return false;
			} else {
				// verifica se somente o saldo é suficiente.
				if (valor > getSaldo()) {
					limite -= valor - saldo;
					saldo = 0;
				} else {
					saldo -= valor;
				}
			}
		}
		return true;
	}

}
