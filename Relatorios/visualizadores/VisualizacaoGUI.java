package Relatorios.visualizadores;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Relatorios.VisualizadorDeRelatorios;
import java.awt.Color;

public class VisualizacaoGUI implements VisualizadorDeRelatorios{

    @Override
    public void gerarVisualizacaoDoRelatorio(String cabecalho, String conteudo) {
    	JFrame frame = new JFrame("Relatorio");
    	frame.setSize(new Dimension(500,500));
    	JTextArea jTextArea = new JTextArea();
		jTextArea.setFont(new Font("Courier New", Font.BOLD, 15));
    	jTextArea.append(cabecalho);
    	jTextArea.append(conteudo);
    	frame.add(jTextArea);
    	frame.setVisible(true);
		frame.setBackground(Color.YELLOW);
    }
    
}