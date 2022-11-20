package front.javax;

public class FactoryMethodInterface {

	public static final String ABERTURA = "Abertura";
	public static final String PRINCIPAL = "Principal";
	public static final String LOGIN = "Login";
	public static final String CREDITOS = "Creditos";
	public static final String REGRA1 = "Regra1";
	public static final String REGRA2 = "Regra2";
	public static final String REGRA3 = "Regra3";
	public static final String REGRA4 = "Regra4";
	public static final String REGRA5 = "Regra5";
	public static final String MENSAGEM = "Mensagem";

	public static FacInterface getModel(String qualTela) {

		switch (qualTela) {
			case "Abertura":
				return new Abertura();
			case "Principal":
				return new Principal();
			case "Login":
				return new Login();
			case "Creditos":
				return new Creditos();
			case "Regra1":
				return new regra1();
			case "Regra2":
				return new regra2();
			case "Regra3":
				return new regra3();
			case "Regra4":
				return new regra4();
			case "Regra5":
				return new regra5();
			default:
				return new Abertura();
		}

	}

	public static FacInterface getMensagem(boolean ok, String titulo, String msTitulo, String mensagem,
			String comentario,
			String nomeDoBemImagem) {

		return new mensagem(ok, titulo, msTitulo, mensagem, comentario, nomeDoBemImagem);
	}
}
