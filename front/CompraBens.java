package front;

import console.Ferramentas;
import console.Global;
import dominio.Operacoes;

public class CompraBens extends OrderState {
	Operacoes o = new Operacoes();
	Ferramentas f = new Ferramentas();
    @Override
    public String doWork(Boolean ok) {
        // String nomedoBem = qual;
        // String valorCompra = f.cMB(o.valorCompraBem(nomedoBem));
        if (ok) {
            Global.MSGOK = true;
            return "Parabéns!! Você acaba de adquirir um novo imovel!";
            // Global.MSG = "Parabéns!! Você acaba de adquirir um novo imovel!";
            // Global.MSG2 = "Valor da Compra R$" + valorCompra;
            // FactoryMethodInterface.getModel("Mensagem");
        } else {
            Global.MSGOK = false;
            return "Acho que não foi dessa vez, falta pouco!";
            // Global.MSG = "Acho que não foi dessa vez, falta pouco!";
            // FactoryMethodInterface.getModel("Mensagem");
            // Global.MSG2 = "Valor do Bem R$" + valorCompra;
        }
    }
    
}
