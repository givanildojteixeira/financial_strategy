package bancoDados;

import bancoDados.dbPropertiesFiles.IdFiles;

public abstract class ABSConnector {
    
	public abstract void createConnection(IdFiles id);

    public abstract void grava(String chave, String valor, IdFiles id);

    public abstract String le(String chave, IdFiles id);




	
}
