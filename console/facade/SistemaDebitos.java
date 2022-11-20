package console.facade;

import bancoDados.dbPropertiesFiles.IdFiles;
import console.Global;
import dominio.Operacoes;

public class SistemaDebitos implements Facade{

    Operacoes o = new Operacoes();

    @Override
    public double todosOsBens() {
        double r = 0;
        r += o.leDBValor(Global.USUARIO + "-Casa-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Apartamento-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Comercio-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Fazenda-Despesa", IdFiles.FileConfig);
        return r;
    }

    @Override
    public double todosOsRendimentos() {
        double r = 0;
        r += o.leDBValor(Global.USUARIO + "-Acoes-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-FundoImobiliario-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-FundoRendaFixa-Despesa", IdFiles.FileConfig);
        r += o.leDBValor(Global.USUARIO + "-Poupanca-Despesa", IdFiles.FileConfig);
        return r;
    }
    
}
