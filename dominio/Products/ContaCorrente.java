package dominio.Products;

import dominio.ContaBuilder;

public class ContaCorrente extends ContaBuilder{

    @Override
    public void buildEspecial() {
        conta.setEspecial(false);
    }

    @Override
    public void buildLimite() {
        conta.setLimite(5000);
    }


    @Override
    public void buildSaldo() {
        conta.setSaldo(0);
        
    }

    @Override
    public void buildTipo() {
        conta.setTipo("Corrente");
        
    }

    @Override
    public void buildTipoAbreviado() {
        conta.setTipoAbreviado("");  
    }
    

}
