package bancoDados;

public class MySQL extends DatabaseFactory{

	@Override
	public ABSConnector createConnector() {
		return new MySQLConnector();
	}

}
