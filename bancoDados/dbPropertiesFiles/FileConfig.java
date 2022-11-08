package bancoDados.dbPropertiesFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import bancoDados.DBPropertiesConnector;

public class FileConfig extends FileChain {
	protected String arquivo;
	private Properties prop = new Properties();

	public FileConfig() {
		super(IdFiles.FileConfig);
		IdFiles s = IdFiles.FileConfig;
		arquivo = s.getArquivo();
	}

	// se caiu para esse arquivo, então
	// acrescente a funcionalidade de codificação
	private FileConfigDecorator fcd = new FileConfigDecorator();

	@Override
	public void createConnection() {
		// verifica se o arquivo existe

		try (InputStream input = DBPropertiesConnector.class.getClassLoader().getResourceAsStream(arquivo)) {
			if (input == null) {
				OutputStream output = new FileOutputStream(arquivo);
				prop.setProperty("db.url", "localhost");
				prop.setProperty("db.banco", "properties");
				prop.store(output, null);
				return;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void gravar(String chave, String valor) {
		try {
			FileInputStream fis = new FileInputStream(arquivo);
			prop.load(fis);

			valor = fcd.Codifica(valor);

			prop.setProperty(chave, valor);
			FileOutputStream fos = new FileOutputStream(arquivo);
			prop.store(fos, null);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String ler(String chave) {
		try {
			FileInputStream fis = new FileInputStream(arquivo);
			prop.load(fis);
			String s = prop.getProperty(chave);
			fis.close();
			if (s != null)
				s = fcd.Decodifica(s);
			return s;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
