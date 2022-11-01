package Relatorios.modelos;

import Relatorios.GeradorDeRelatorios;
import Relatorios.VisualizadorDeRelatorios;
import console.Ferramentas;
import dominio.Operacoes;

public class ExtratosConta extends GeradorDeRelatorios {
	Ferramentas f = new Ferramentas();
	Operacoes o = new Operacoes();

	public ExtratosConta(VisualizadorDeRelatorios visualizador) {
		super(visualizador);
	}

	@Override
	protected String gerarCabecalho() {
		String extrato = "";
		extrato += "-------------------------------\n";
		extrato += "-    SALDO CONTA CORRENTE   -\n";
		extrato += "-------------------------------\n";
		extrato += "Conta Nro: " + o.getNroconta() + "\n";
		extrato += "Cliente  : " + o.getCliente() + "\n";
		extrato += "Tipo Cta : " + o.getTipo() + "\n";
		extrato += "Especial : " + o.getEstpecial() + "\n";
		extrato += "-------------------------------\n";
		return extrato;
	}

	@Override
	protected String gerarConteudo() {
		String extrato = "";
		extrato += "Saldo            | R$" + f.cMB(o.getSaldo()) + "\n";
		extrato += "Limite           | R$" + f.cMB(o.getLimite()) + "\n";
		extrato += "-------------------------------\n";
		return extrato;

	}

	@Override
	protected void gerarVisualizacao(String cabecalho, String conteudo) {
		this.visualizador.gerarVisualizacaoDoRelatorio(cabecalho, conteudo);

	}

}
