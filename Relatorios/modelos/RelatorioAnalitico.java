package Relatorios.modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Relatorios.GeradorDeRelatorios;
import Relatorios.VisualizadorDeRelatorios;
import bancoDados.dbPropertiesFiles.IdFiles;
import console.Ferramentas;
import console.Global;
import dominio.Movimentacao;
import dominio.Operacoes;

public class RelatorioAnalitico extends GeradorDeRelatorios {

    /**
     * Construtor recebendo o visualizador (que está na classe mae)
     * 
     * @param visualizador
     */
    public RelatorioAnalitico(VisualizadorDeRelatorios visualizador) {
        super(visualizador);
    }

    Ferramentas f = new Ferramentas();
    Operacoes o = new Operacoes();

    @Override
    protected String gerarCabecalho() {
        String extrato = "";
        extrato += "----------------------------------------------\n";
        extrato += "-           EXTRATO MOVIMENTAÇOES            -\n";
        extrato += "----------------------------------------------\n";
        extrato += "Conta Nro: " + o.getNroconta() + "\n";
        extrato += "Cliente  : " + o.getCliente() + "\n";
        extrato += "----------------------------------------------\n";
        return extrato;
    }

    @Override
    protected String gerarConteudo() {
        return o.leDB(Global.USUARIO + "-MOV-|", IdFiles.FileMovimento);
    }

    @Override
    protected void gerarVisualizacao(String cabecalho, String conteudo) {
        this.visualizador.gerarVisualizacaoDoRelatorio(cabecalho, conteudo);
    }

}