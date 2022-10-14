package bancoDados;

public class Firebase extends DatabaseFactory{

	@Override
	public ABSConnector createConnector() {
		return new FirebaseConnector();
	}

}
