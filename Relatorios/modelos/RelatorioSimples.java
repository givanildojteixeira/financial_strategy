package Relatorios.modelos;

import java.util.List;

import Relatorios.GeradorDeRelatorios;
import Relatorios.VisualizadorDeRelatorios;
import dominio.Movimentacao;

public class RelatorioSimples extends GeradorDeRelatorios {

	/**
	 * Construtor recebendo o visualizador (que está na classe mae)
	 * 
	 * @param visualizador
	 */
	public RelatorioSimples(VisualizadorDeRelatorios visualizador) {
		super(visualizador);
	}

	@Override
	protected String gerarConteudo(List<Movimentacao> mov) {
		double totalProduto = 0;
		StringBuilder conteudo = new StringBuilder();
		// for (Movimentacao produto : mov) {
		// 	totalProduto += 1;
		// }
		conteudo.append("QUANTIDADE VENDIDA: " + mov.size());
		conteudo.append("\nTOTAL VENDIDO: " + totalProduto);
		return conteudo.toString();
	}

	@Override
	protected void gerarVisualizacao(String cabecalho, String conteudo) {
		this.visualizador.gerarVisualizacaoDoRelatorio(cabecalho, conteudo);
	}
}