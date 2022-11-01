package Relatorios.modelos;

import Relatorios.GeradorDeRelatorios;
import Relatorios.VisualizadorDeRelatorios;
import console.Ferramentas;
import dominio.Operacoes;

public class RelatorioSimples extends GeradorDeRelatorios {

	/**
	 * Construtor recebendo o visualizador (que está na classe mae)
	 * 
	 * @param visualizador
	 */
	public RelatorioSimples(VisualizadorDeRelatorios visualizador) {
		super(visualizador);
	}

	Ferramentas f = new Ferramentas();
	Operacoes o = new Operacoes();
	
	@Override
	protected String gerarConteudo() {
		StringBuilder conteudo = new StringBuilder();
		conteudo.append("Casa       : " + o.QualificaBem("Casa") + "\n");
		conteudo.append("Apartamento: " + o.QualificaBem("Apartamento")+ "\n");
		conteudo.append("Comercio   : " + o.QualificaBem("Comercio")+ "\n");
		conteudo.append("Fazenda    : " + o.QualificaBem("Fazenda")+ "\n");

		conteudo.append("Acoes      : " + o.QualificaBem("Acoes")+ "\n");
		conteudo.append("FundoImobi.: " + o.QualificaBem("FundoImobiliario")+ "\n");
		conteudo.append("FundoRendaF: " + o.QualificaBem("FundoRendaFixa")+ "\n");
		conteudo.append("Poupanca   : " + o.QualificaBem("Poupanca")+ "\n");

		return conteudo.toString();
	}

	@Override
	protected void gerarVisualizacao(String cabecalho, String conteudo) {
		this.visualizador.gerarVisualizacaoDoRelatorio(cabecalho, conteudo);
	}

	@Override
	protected String gerarCabecalho() {
		String extrato = "";
		extrato += "----------------------------------------------\n";
		extrato += "-           EXTRATO PATRIMONIO               -\n";
		extrato += "----------------------------------------------\n";
		extrato += "Conta Nro: " + o.getNroconta() + "\n";
		extrato += "Cliente  : " + o.getCliente() + "\n";
		extrato += "----------------------------------------------\n";
		return extrato;
	}
}