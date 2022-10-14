package bancoDados;

public class Connector {

	public static DatabaseFactory DB;
	static ABSConnector con;

	public void connectar(String banco) {

		switch (banco) {
			case "Firebase":
				DB = new Firebase();
				break;
			case "MySQL":
				DB = new MySQL();
			default:
				DB = new DBProperties();
				break;
		}
		con = DB.createConnector();
		con.createConnection();
	}

	public static void gravar(String chave, String valor) {
		con.grava(chave, valor);
	}

	public static String le(String chave) {
		return con.le(chave);
	}

}
