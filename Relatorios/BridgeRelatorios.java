package Relatorios;

import Relatorios.modelos.ExtratosConta;
import Relatorios.modelos.RelatorioAnalitico;
import Relatorios.modelos.RelatorioSimples;
import Relatorios.visualizadores.VisualizacaoConsole;
import Relatorios.visualizadores.VisualizacaoGUI;

public class BridgeRelatorios {

        // List<Movimentacao> movimento = new ArrayList<>();
        // movimento.add(new Produto("Mouse", 10));
        // produtos.add(new Produto("Computador", 1999));
        // produtos.add(new Produto("LexLox 360", 500));
        // produtos.add(new Produto("Peteca", 5));

        VisualizacaoConsole visualizacaoConsole = new VisualizacaoConsole();
        VisualizacaoGUI visualizacaoGUI = new VisualizacaoGUI();

        public void GerarRelatorio(String relatorio, String visualizador) {

                if (visualizador.equals("CONSOLE")) {
                        switch (relatorio) {
                                case "EXTRATO":
                                        GeradorDeRelatorios extrato = new ExtratosConta(visualizacaoConsole);
                                        extrato.gerarRelatorios();
                                        break;
                                case "ANALITICO":
                                        GeradorDeRelatorios relatorioAnalitico = new RelatorioAnalitico(visualizacaoConsole);
                                        relatorioAnalitico.gerarRelatorios();
                                        break;
                                case "SINTETICO":
                                        GeradorDeRelatorios relatorioSimples = new RelatorioSimples(visualizacaoConsole);
                                        relatorioSimples.gerarRelatorios();
                                        break;
                        }

                } else {
                        switch (relatorio) {
                                case "EXTRATO":
                                        GeradorDeRelatorios extrato = new ExtratosConta(visualizacaoGUI);
                                        extrato.gerarRelatorios();
                                        break;
                                case "ANALITICO":
                                        GeradorDeRelatorios relatorioAnalitico = new RelatorioAnalitico(visualizacaoGUI);
                                        relatorioAnalitico.gerarRelatorios();
                                        break;
                                case "SINTETICO":
                                        GeradorDeRelatorios relatorioSimples = new RelatorioSimples(visualizacaoGUI);
                                        relatorioSimples.gerarRelatorios();
                                        break;
                        }
                }

        }
}
