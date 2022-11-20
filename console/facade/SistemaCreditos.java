package console.facade;

import bancoDados.dbPropertiesFiles.IdFiles;
import console.Global;
import dominio.Operacoes;

public class SistemaCreditos implements Facade{
    Operacoes o = new Operacoes();

    @Override
    public double todosOsBens() {
        double r = 0;
        r += o.leDBValor(Global.USUARIO + "-Casa-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Apartamento-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Comercio-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Fazenda-Retorno", IdFiles.FileConfig);
        return r;
    }

    @Override
    public double todosOsRendimentos() {
        double r = 0;
        r += o.leDBValor(Global.USUARIO + "-Acoes-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-FuncoImobiliario-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-FundoRendaFixa-Retorno", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Poupanca-Retorno", IdFiles.FileConfig);
        return r;
    }

    
}
