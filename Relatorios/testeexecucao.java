package Relatorios;

import java.util.ArrayList;
import java.util.List;

import Relatorios.visualizadores.VisualizacaoConsole;
import Relatorios.visualizadores.VisualizacaoGUI;
import dominio.Movimentacao;

public class testeexecucao {

        List<Movimentacao> movimento = new ArrayList<>();
        // movimento.add(new Produto("Mouse", 10));
        // produtos.add(new Produto("Computador", 1999));
        // produtos.add(new Produto("LexLox 360", 500));
        // produtos.add(new Produto("Peteca", 5));
        
        VisualizacaoConsole visualizacaoConsole = new VisualizacaoConsole();
        VisualizacaoGUI visualizacaoGUI = new VisualizacaoGUI();

        // GeradorDeRelatorios relatorioSimples = new RelatorioSimples(visualizacaoGUI);
        // relatorioSimples.gerarRelatorios(movimento);
        
        // GeradorDeRelatorios relatorioAnalitico = new RelatorioAnalitico(visualizacaoConsole);
        // relatorioAnalitico.gerarRelatorios(movimento);    
}
