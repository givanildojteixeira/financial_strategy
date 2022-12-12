package console;

public interface Oraculo {
    //Auxiliar do Padrao Observer - O olho que tudo vê!

    public boolean preliminar();
    public void dificuldade();
    public boolean usoLimite();
    public boolean vencedor();
    public boolean perdedor();
    public void extraPorTempoJogando();
    public void pegoAleatorioPeloImpostoDeRenda();
    public void melhorJogada();
    public void piorJogada();
    public void meritoInvestidor();

}
