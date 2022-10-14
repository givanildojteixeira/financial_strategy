package bancoDados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class DBPropertiesConnector extends ABSConnector {

	public String arquivo = "resources/config.properties";
	private Properties prop = new Properties();
	

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
	public void grava(String chave, String valor) {
		try {
			OutputStream output = new FileOutputStream(arquivo);
			prop.setProperty(chave, valor);
			prop.store(output, null);
			return;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String le(String chave) {
		try (InputStream input = DBPropertiesConnector.class.getClassLoader().getResourceAsStream(arquivo)) {

			prop.load(input);
			return prop.getProperty(chave);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "";



		// Global.USUARIO = (String) prop.setProperty("db.user", "");
		// Global.SALDO= (double) prop.setProperty("db.saldo", "");
	

	}

}