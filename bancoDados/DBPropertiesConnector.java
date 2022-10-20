package bancoDados;

import java.io.FileInputStream;
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
			FileInputStream fis = new FileInputStream(arquivo);
			prop.load(fis);
			prop.setProperty(chave, valor);
			FileOutputStream fos = new FileOutputStream(arquivo);
			prop.store(fos, null);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String le(String chave) {

		try (InputStream inputStream = new FileInputStream(arquivo)) {
			String s = prop.getProperty(chave);
			inputStream.close();
			return s;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}

}