package bancoDados;

import bancoDados.dbPropertiesFiles.*;

public class Connector {

	public static DatabaseFactory DB;
	static ABSConnector con;

	public void connectar(String banco, IdFiles id) {

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
		con.createConnection(id);		
	}


	public static void gravar(String chave, String valor, IdFiles id) {
		con.grava(chave, valor, id);
	}

	public static String le(String chave, IdFiles id) {
		return con.le(chave, id);
	}

}
