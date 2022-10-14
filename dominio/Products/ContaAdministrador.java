package dominio.Products;

import dominio.ContaBuilder;

public class ContaAdministrador extends ContaBuilder{

    @Override
    public void buildEspecial() {
        conta.setEspecial(false);
    }

    @Override
    public void buildLimite() {
        conta.setLimite(0);
    }


    @Override
    public void buildSaldo() {
        conta.setSaldo(0);
        
    }

    @Override
    public void buildTipo() {
        conta.setTipo("Administrador");
        
    }

    @Override
    public void buildTipoAbreviado() {
        conta.setTipoAbreviado("[Adm]");  
    }

}
