package Relatorios.visualizadores;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Relatorios.VisualizadorDeRelatorios;

public class VisualizacaoGUI implements VisualizadorDeRelatorios{

    @Override
    public void gerarVisualizacaoDoRelatorio(String cabecalho, String conteudo) {
    	JFrame frame = new JFrame("Relatorio");
    	frame.setSize(new Dimension(500,500));
    	JTextArea jTextArea = new JTextArea();
    	jTextArea.append(cabecalho);
    	jTextArea.append(conteudo);
    	frame.add(jTextArea);
    	frame.setVisible(true);
    }
    
}