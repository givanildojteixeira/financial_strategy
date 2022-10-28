package Relatorios.visualizadores;

import Relatorios.VisualizadorDeRelatorios;

public class VisualizacaoConsole implements VisualizadorDeRelatorios{

    @Override
    public void gerarVisualizacaoDoRelatorio(String cabecalho, String conteudo) {
    	System.out.println(cabecalho);
        System.out.println(conteudo);
    }
    
}