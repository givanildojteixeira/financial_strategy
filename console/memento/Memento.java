package console.memento;

import java.io.IOException;

public abstract class Memento {

    protected abstract void adicionarMomento() throws IOException;
    protected abstract String desfazUltimoMomento() throws IOException;
    protected abstract void limpaMomentos();
    protected abstract String mostraMomentos();

    
}
