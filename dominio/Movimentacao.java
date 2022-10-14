package dominio;

import console.Global;

public class Movimentacao {

	private String tipo, descricao;
	private double valor;
	private int nconta, operacao;

	Global.IdentificadorOperacao identificador = Global.IdentificadorOperacao.getInstance();

	public Movimentacao() {
	}

	public Movimentacao(int nconta, String tipo, String descricao, double valor) {
		this.nconta = nconta;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.operacao = identificador.novo();
	}

	public int getNconta() {
		return nconta;
	}

	public void setNconta(int nconta) {
		this.nconta = nconta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getOperacao() {
		return operacao;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	

}
