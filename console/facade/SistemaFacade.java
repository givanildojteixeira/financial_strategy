package console.facade;

public class SistemaFacade {
    protected SistemaCreditos creditos;
    protected SistemaDebitos debitos;
    protected double rendimentos = 0;
    protected double despesas = 0;

    public double analiseReceitas() {
        creditos = new SistemaCreditos();
        rendimentos += creditos.todosOsBens();
        rendimentos += creditos.todosOsRendimentos();
        return rendimentos;
    }

    public double analiseDespesas() {
        debitos = new SistemaDebitos();
        despesas += debitos.todosOsBens();
        despesas += debitos.todosOsRendimentos();
        return despesas;
    }

}
