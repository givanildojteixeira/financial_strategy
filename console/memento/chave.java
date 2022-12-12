package console.memento;

import java.io.IOException;

public class chave {
    public void testes() throws IOException{
        DbMemento m = new DbMemento();
        m.adicionarMomento();
        m.adicionarMomento();
        m.adicionarMomento();
        m.adicionarMomento();
        m.adicionarMomento();
        m.adicionarMomento();

        System.out.println(m.mostraMomentos());
        System.out.println(m.desfazUltimoMomento());
        System.out.println(m.desfazUltimoMomento());
        System.out.println(m.desfazUltimoMomento());
        System.out.println(m.desfazUltimoMomento());

}
}
