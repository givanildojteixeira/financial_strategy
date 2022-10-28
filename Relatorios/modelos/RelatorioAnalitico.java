package Relatorios.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Relatorios.GeradorDeRelatorios;
import Relatorios.VisualizadorDeRelatorios;
import dominio.Movimentacao;

public class RelatorioAnalitico extends GeradorDeRelatorios {

	/**
	 * Construtor recebendo o visualizador (que está na classe mae)
	 * 
	 * @param visualizador
	 */
    public RelatorioAnalitico(VisualizadorDeRelatorios visualizador) {
		super(visualizador);
	}

	@Override
    protected String gerarCabecalho(){
        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s d/M/y G");
        return new String(
            "RELATORIO ANALÍTICO DE PRODUTOS VENDIDOS\n"+
            sdf.format(new Date()) +
            "\nBLSoft Sistemas Dev Corp.\n"
        );
    }

    @Override
    protected String gerarConteudo(List<Movimentacao> movimento) {
        StringBuilder conteudo = new StringBuilder();
        double totalProdutos = 0;
        conteudo.append("\nMOVIMENTO\n");
        for (Movimentacao movimentacao : movimento) {
            conteudo.append(movimentacao.getDescricao()+ "\n");
            // conteudo.append(produto.getNome() + "R$ " + produto.getPreco() + "\n");
        }
        conteudo.append("\nTOTAL EM R$" + totalProdutos);
        return conteudo.toString();
    }

    @Override
    protected void gerarVisualizacao(String cabecalho, String conteudo) {
        this.visualizador.gerarVisualizacaoDoRelatorio(cabecalho, conteudo);
    }
    
}