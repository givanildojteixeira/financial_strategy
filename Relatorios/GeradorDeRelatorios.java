package Relatorios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dominio.Movimentacao;


public abstract class GeradorDeRelatorios {

	/**
	 * Abstração dos visualizadores de relatórios
	 */
	protected VisualizadorDeRelatorios visualizador;

	/**
	 * Construtor que precisa de um visualizador
	 * 
	 * @param visualizador
	 */
	public GeradorDeRelatorios(VisualizadorDeRelatorios visualizador) {
		this.visualizador = visualizador;
	}

	/**
	 * Methodo template (template Method) Organiza as chamadas dos métodos na ordem
	 * necessária
	 * 
	 * @param Movimentacao
	 */
	public final void gerarRelatorios(List<Movimentacao> movimento) {
		String cabecalho = this.gerarCabecalho();
		String conteudo = this.gerarConteudo(movimento);
		this.gerarVisualizacao(cabecalho, conteudo);
	}

	/**
	 * Gera um cabeçalho padrão e simplificado
	 * 
	 * @return String cabeçalho
	 */
	protected String gerarCabecalho() {
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
		return new String(
				"RELATORIO DE PRODUTOS VENDIDOS\n" + sdf.format(new Date()) + "\nBLSoft Sistemas Dev Corp.\n");
	}

	/**
	 * Deixa a geração de conteúdo para as subclasses
	 */
	protected abstract String gerarConteudo(List<Movimentacao> movimento);

	/**
	 * Deixa a visualização para as subclasses e ainda: cada subclasse vai (pode)
	 * ter um visualizador diferente Dependendo do que a gente injetar no campo
	 * VisualizadorDeRelatorios visualizador dessa classe aqui
	 */
	protected abstract void gerarVisualizacao(String cabecalho, String conteudo);

}