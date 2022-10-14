package dominio.Products;

import dominio.ContaBuilder;

public class ContaPro extends ContaBuilder{

    @Override
    public void buildEspecial() {
        conta.setEspecial(true);
    }

    @Override
    public void buildLimite() {
        conta.setLimite(10000);
    }


    @Override
    public void buildSaldo() {
        conta.setSaldo(0);
        
    }

    @Override
    public void buildTipo() {
        conta.setTipo("Pro");
        
    }

    @Override
    public void buildTipoAbreviado() {
        conta.setTipoAbreviado("[Pro]");  
    }

}
