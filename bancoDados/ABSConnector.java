package bancoDados;

public abstract class ABSConnector {

	public abstract void createConnection();

    public abstract void grava(String chave, String valor);

    public abstract String le(String chave);

	
}
