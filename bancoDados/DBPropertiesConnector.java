package bancoDados;

import bancoDados.dbPropertiesFiles.FileChain;
import bancoDados.dbPropertiesFiles.FileConfig;
import bancoDados.dbPropertiesFiles.FileMovimento;
import bancoDados.dbPropertiesFiles.IdFiles;


public class DBPropertiesConnector extends ABSConnector {

	FileChain fileProperties;

	public FileChain OrdemResponsabilidadeChain() {
		FileChain fileProperties = new FileConfig();
		fileProperties.setNext(new FileMovimento());
		return fileProperties;
	}

	@Override
	public void createConnection(IdFiles id) {
		fileProperties = OrdemResponsabilidadeChain();
		fileProperties.createConnection(id);
	}

	@Override
	public void grava(String chave, String valor, IdFiles id) {
		fileProperties = OrdemResponsabilidadeChain();
		fileProperties.grava(chave, valor, id);

	}

	@Override
	public String le(String chave, IdFiles id) {
		fileProperties = OrdemResponsabilidadeChain();
		return fileProperties.le(chave, id);
	}

}