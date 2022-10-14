package bancoDados;

public class DBProperties extends DatabaseFactory{

	@Override
	public ABSConnector createConnector() {
		return new DBPropertiesConnector();
	}
}
